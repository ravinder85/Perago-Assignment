package xyz.foobar;

public class DiffRendererService implements DiffRenderer {
    @Override
    public String render(Diff<?> diff) throws DiffException {
        System.out.println("diff$$$$"+diff.getParent());
        return null;
    }
}
