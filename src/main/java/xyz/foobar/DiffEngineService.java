package xyz.foobar;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;



public class DiffEngineService implements DiffEngine {

	 public <T extends Serializable> T apply(T original, Diff<?> diff) throws DiffException {
	        if ( diff == null || (diff != null && diff.getObj() == null)) return null;

	        @SuppressWarnings("unchecked")
			T clone = original == null ? (T) diff.getObj() : SerializationUtils.clone(original);

	        for (String field : diff.getFields()) {
	            try {
	                Field field1 = original.getClass().getDeclaredField(field);
	                field1.setAccessible(true);
	                field1.set(clone, field1.get(diff.getObj()));
	            } catch (IllegalAccessException e) {
	                throw new DiffException(e);
	            } catch (NoSuchFieldException e) {
	                throw new DiffException(e);
	            }
	        }
	        return clone;
	    }

	    public <T extends Serializable> Diff<T> calculate(T original, T modified) throws DiffException {
	        Diff<T> tDiff = null;
	        if (original != null) {
	            tDiff = new Diff<>();
	            tDiff.setObj(modified);
	            diff(original, modified, tDiff);
	        } else if (modified != null) {
	            try {
	                tDiff = new Diff<>();
	                tDiff.setObj(modified);
	                original = (T) modified.getClass().newInstance();
	                diff(original, modified, tDiff);
	            } catch (InstantiationException e) {
	                throw new DiffException(e);
	            } catch (IllegalAccessException e) {
	                throw new DiffException(e);
	            }
	        }
	        return tDiff;
	    }

	    private <T extends Serializable> void diff(T original, T modified, Diff<T> tDiff) throws DiffException {
	        List<String> fields = new ArrayList<>();
	        if (modified != null) {
	            for (Field field : Arrays.asList(modified.getClass().getDeclaredFields())) {
	                field.setAccessible(true);
	                try {

	                    if (valueChanged(original, modified, field)) {
	                        fields.add(field.getName());
	                        if (field.getType().getName().equals(modified.getClass().getName())) {
	                            tDiff.setInner(calculate(null, (T)field.get(modified)));
	                            tDiff.getInner().setParent(field.getName());
	                        }
	                    }
	                } catch (Exception e) {
	                    throw new DiffException(e);
	                }
	            }
	        }
	        tDiff.getFields().addAll(fields);
	    }


	    private <T extends Serializable> boolean valueChanged(T original, T modified, Field field) throws IllegalAccessException {
	        return field.get(modified) != null && (original == null  || !field.get(modified).equals(field.get(original)));
	    }
	}
