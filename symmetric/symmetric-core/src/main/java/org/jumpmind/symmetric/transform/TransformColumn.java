package org.jumpmind.symmetric.transform;

public class TransformColumn {

    protected String sourceColumnName;
    protected String targetColumnName;
    protected boolean pk;
    protected String transformType;
    protected String transformExpression;

    public String getSourceColumnName() {
        return sourceColumnName;
    }

    public void setSourceColumnName(String sourceColumnName) {
        this.sourceColumnName = sourceColumnName;
    }

    public String getTargetColumnName() {
        return targetColumnName;
    }

    public void setTargetColumnName(String targetColumnName) {
        this.targetColumnName = targetColumnName;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public String getTransformType() {
        return transformType;
    }

    public void setTransformType(String transformType) {
        this.transformType = transformType;
    }

    public String getTransformExpression() {
        return transformExpression;
    }

    public void setTransformExpression(String transformExpression) {
        this.transformExpression = transformExpression;
    }

}
