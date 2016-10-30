package validate;

public interface PanelData {

	// I don't really understand how it's all wired up in the panels, so context
	// and qualifiers will just be ignored. But from what I can tell from the
	// ValidationHelper's runValidators method, each validator can be determined from a small set of pre-defined arguments 
	public Validator validator(String context, String store, String qualifiers);

}
