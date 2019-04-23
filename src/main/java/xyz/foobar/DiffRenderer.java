package xyz.foobar;

/**
 * Your diff rendering service must implement this interface
 *
 */
public interface DiffRenderer {

	/**
	 * Render a diff in a human-readable, hierarchical format
	 * @param diff The diff to be rendered
	 * @return String representing the diff in human-readable format
	 * @throws DiffException
	 */
	public String render(Diff<?> diff) throws DiffException;
}
