import java.util.HashMap;
//Singlton class with inner class of Spacecraft model
//default mode in this class

public class SpacecraftFactory {
    private HashMap craftModel;
    private static SpacecraftFactory factory = new SpacecraftFactory();

    private SpacecraftFactory(){
        craftModel = new HashMap();
    }

    public synchronized ICraftModel getSpacecraftModel(String type) {
        if (craftModel.get(type) == null){
            ICraftModel iCraftModel = new SpacecraftModel(type);
            craftModel.put(type, iCraftModel);
            return iCraftModel;
        } else {
          return (ICraftModel)craftModel.get(type);
        }
    }

    public static SpacecraftFactory getInstance(){
        return factory;
    }

    private class SpacecraftModel implements ICraftModel {

        private String modelMesh;
        private String modelTexture;
        private int maxSpeed;
        private float acceleration;
        private float damage;

        public void setValues(String modelMesh, String modelTexture, int maxSpeed, float acceleration, float damage) {
            this.modelMesh = modelMesh;
            this.modelTexture = modelTexture;
            this.maxSpeed = maxSpeed;
            this.acceleration = acceleration;
            this.damage = damage;
        }

        private SpacecraftModel(String type){
            if (type.equals("NukeMayhem")) {
                setValues("Mesh1", "Texture1", 100, 10, 10);
            }
            if (type.equals("CoreDriller"))
            {
                setValues("Mesh2","Texture2", 200, 20,20);
            }
            if (type.equals("SwiftMaple")){
                setValues("Mesh3", "Texture3", 300, 30, 30);
            }
        }

        @Override
        public String getMesh() {
            return modelMesh.toString();
        }

        @Override
        public String getTexture() {
            return modelTexture.toString();
        }

        @Override
        public int getMaxSpeed() {
            return maxSpeed;
        }

        @Override
        public float getAcceleration() {
            return acceleration;
        }

        @Override
        public float getDamage() {
            return damage;
        }
    }
}
