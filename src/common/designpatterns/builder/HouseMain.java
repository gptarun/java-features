package common.designpatterns.builder;

public class HouseMain {
    public static void main(String[] args) {
        House house = new House.HouseBuilder("Concrete", "Brick")
                .setRooms(3)
                .setHasGarage(true)
                .setHasSwimmingPool(true)
                .build();
        System.out.println(house);
    }
}
