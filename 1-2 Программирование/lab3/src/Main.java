import classes.characters.*;
import classes.items.CarpetBeater;
import classes.rooms.BigRoom;
import classes.rooms.Hallway;
import enums.Direction;
import exceptions.InvalidCharacterSpeedException;
import records.Position;

public class Main {
    public static void main(String[] args) throws InvalidCharacterSpeedException{
        BigRoom bigRoom = new BigRoom("Большая комната");
        Hallway hallway = new Hallway("Коридор");
        CarpetBeater carpetBeater = new CarpetBeater("Выбивалка для ковров");
        Karlson karlson = new Karlson("Карлсон", 15, new Position(10, 0), Direction.RIGHT, hallway);
        FrekenBok frekenBok = new FrekenBok("Фрекен Бок", 11, new Position(11, 0), Direction.LEFT, bigRoom, carpetBeater, karlson);
        Kid kid = new Kid("Малыш", 10, new Position(5, 0), Direction.RIGHT, bigRoom, frekenBok);
        Dog bimbo = new Dog("Бимбо", 5, new Position(9, 0), Direction.LEFT, bigRoom, 50);
        System.out.println("Начинается сцена погони");
        karlson.flyTo(bigRoom);
        karlson.makeSound();
        karlson.fly();
        karlson.increaseAltitude(karlson.getAltitude());
        bigRoom.enterRoom(bimbo);
        bigRoom.enterRoom(frekenBok);
        bigRoom.enterRoom(kid);
        bigRoom.showCharactersInRoom();
        frekenBok.run();
        kid.run();
        bimbo.jump();
        bimbo.makeSound();
        karlson.fly();
        if(Math.random() < 0.5) {
            karlson.flyTo(hallway);
            karlson.moveToRoom(hallway);
            bimbo.barkLouder();
            karlson.fly();
            frekenBok.run();
            kid.run();
            bimbo.jump();
            frekenBok.moveToRoom(hallway);
            kid.moveToRoom(hallway);
            bimbo.moveToRoom(hallway);
            hallway.showCharactersInRoom();
            frekenBok.run();
            kid.run();
            karlson.decreaseAltitude(karlson.getAltitude());
            karlson.run();
            kid.takeAwayCarpetBeater();
            if(carpetBeater.getHolder() == kid) {
                System.out.println("Ура! " + karlson.getName() + " спасён!!!");
            }
        } else {
            System.out.println("Погоня продолжается в " + bigRoom.getName());
            frekenBok.run();
            kid.run();
            bimbo.jump();
            karlson.decreaseAltitude(karlson.getAltitude());
            karlson.run();
            frekenBok.run();
        }
    }
}
