import java.util.ArrayList;
//test class

public class SpacecraftTest {
    public static void main(String[] args) {

        //create array list
        //create instance
        ArrayList spacecraftHanger = new ArrayList();
        SpacecraftFactory spacecraftFactory = SpacecraftFactory.getInstance();
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("NukeMayhem"), new Coordinate(1,1,1) , 1));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("NukeMayhem"), new Coordinate(2,2,2) , 2));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("NukeMayhem"), new Coordinate(3,3,3) , 3));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("NukeMayhem"), new Coordinate(4,4,4) , 4));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("CoreDriller"), new Coordinate(1,1,1) , 5));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("CoreDriller"), new Coordinate(2,2,2) , 6));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("CoreDriller"), new Coordinate(3,3,3) , 7));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("SwiftMaple"), new Coordinate(1,1,1) , 8));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("SwiftMaple"), new Coordinate(2,2,2) , 9));
        spacecraftHanger.add(new Spacecraft(spacecraftFactory.getSpacecraftModel("SwiftMaple"), new Coordinate(3,3,3) , 10));

        //print all value
        for (int i = 0; i < spacecraftHanger.size(); i++){
            Spacecraft spacecraft = (Spacecraft)spacecraftHanger.get(i);
            spacecraft.launch();
        }

    }
}
