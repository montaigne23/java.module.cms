package library.utilities.eav.models;

public class attributeOptionModel {
    private boolean isRequired;
    private attributeModel attribute;

    attributeOptionModel(boolean isRequired) {
        this.attribute = new attributeModel();
        this.isRequired = isRequired;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public attributeModel getAttribute() {
        return attribute;
    }

    public void setAttribute(attributeModel attribute) {
        this.attribute = attribute;
    }
}
