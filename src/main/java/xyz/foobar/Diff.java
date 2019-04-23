package xyz.foobar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Ravinder created by 18-04-2919
 * The object representing a diff.
 * Implement this class as you see fit. 
 *
 */
public class Diff<T extends Serializable>{
	
	private String parent;
	private List<String> fields;
	private T obj;
	private Diff<T> inner;

	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((inner == null) ? 0 : inner.hashCode());
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diff other = (Diff) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (inner == null) {
			if (other.inner != null)
				return false;
		} else if (!inner.equals(other.inner))
			return false;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	 public List<String> getFields() {
	        if (fields == null) {
	            fields = new ArrayList<>();
	        }
	        return fields;
	    }

	    public void setObj(T obj) {
	        this.obj = obj;
	    }

	    public T getObj() {
	        return obj;
	    }

	 

	    @Override
	    public String toString() {
	        return "Diff{" +
	                "parent='" + parent + '\'' +
	                ", fields=" + fields +
	                ", obj=" + obj +
	                ", inner=" + inner +
	                '}';
	    }

	    public Diff<T> getInner() {
	        return inner;
	    }

	    public void setInner(Diff<T> inner) {
	        this.inner = inner;
	    }

	    public String getParent() {
	        return parent;
	    }

	    public void setParent(String parent) {
	        this.parent = parent;
	    }
	}
