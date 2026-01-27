abstract class Vehicle {

    protected int speed;
    protected double weight;
    protected String fuelType;
    protected Brake brake;
    protected Seat seat;

    public Vehicle(int speed, double weight, String fuelType) {
        this.speed = speed;
        this.weight = weight;
        this.fuelType = fuelType;
        this.brake = new Brake();
        this.seat = new Seat();
    }

    public abstract void start();
    public abstract void run();
    public abstract void stop();
}

class Car extends Vehicle {

    private Engine engine;
    private Ignition ignition;

    public Car(int speed, double weight, String fuelType) {
        super(speed, weight, fuelType);
        this.engine = new Engine();
        this.ignition = new Ignition();
    }

    @Override
    public void start() {
        ignition.turnOn();
        engine.startEngine();
        System.out.println("Car started");
    }

    @Override
    public void run() {
        System.out.println("Car running at speed " + speed);
    }

    @Override
    public void stop() {
        brake.applyBrake();
        engine.stopEngine();
        System.out.println("Car stopped");
    }
}

class Cycle extends Vehicle {

    public Cycle(int speed, double weight) {
        super(speed, weight, "Manual");
    }

    @Override
    public void start() {
        System.out.println("Cycle started by pedaling");
    }

    @Override
    public void run() {
        System.out.println("Cycle running at speed " + speed);
    }

    @Override
    public void stop() {
        brake.applyBrake();
        System.out.println("Cycle stopped");
    }
}

public class VehicleFactory {

    public static Vehicle createVehicle(String type) {

        if (type.equalsIgnoreCase("CAR")) {
            return new Car(120, 1500, "Petrol");
        } 
        else if (type.equalsIgnoreCase("CYCLE")) {
            return new Cycle(25, 15);
        }
        return null;
    }

    public static void main(String[] args) {

        Vehicle car = VehicleFactory.createVehicle("CAR");
        car.start();
        car.run();
        car.stop();

        System.out.println("----------------------");

        Vehicle cycle = VehicleFactory.createVehicle("CYCLE");
        cycle.start();
        cycle.run();
        cycle.stop();
    }
}

class Engine {

    public void startEngine() {
        System.out.println("Engine started");
    }

    public void stopEngine() {
        System.out.println("Engine stopped");
    }
}

class Ignition {

    public void turnOn() {
        System.out.println("Ignition ON");
    }

    public void turnOff() {
        System.out.println("Ignition OFF");
    }
}

class Brake {

    public void applyBrake() {
        System.out.println("Brake applied");
    }
}

class Seat {

    private int seatCount = 1;

    public int getSeatCount() {
        return seatCount;
    }
}