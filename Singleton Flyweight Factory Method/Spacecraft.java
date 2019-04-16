//spacecraft, has craftmodel, coordinate, and id
//Coordinate Class for new instance
//Launch to print

public class Spacecraft {
    private ICraftModel craftModel;
    private Coordinate coordinate;
    private int craftID;

    public Spacecraft(ICraftModel craftModel, Coordinate coordinate, int craftID) {
        this.craftModel = craftModel;
        this.coordinate = coordinate;
        this.craftID = craftID;
    }

    public void launch(){
        System.out.println(craftModel.getMesh() + "-" + craftModel.getTexture() + "-"  + craftModel.getMaxSpeed() + "-" + craftModel.getAcceleration() + "-" + craftModel.getDamage());
        System.out.println(coordinate);
        System.out.println(craftID);
    }

    public ICraftModel getCraftModel() {
        return craftModel;
    }

    public void setCraftModel(ICraftModel craftModel) {
        this.craftModel = craftModel;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getCraftID() {
        return craftID;
    }

    public void setCraftID(int craftID) {
        this.craftID = craftID;
    }


}
