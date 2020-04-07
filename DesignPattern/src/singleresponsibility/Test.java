package singleresponsibility;

public class Test {
    public static void main(String[] args) {
        /*Bird bird = new Bird();
        bird.mainMoveMode("zaza");
        bird.mainMoveMode("tits");*/
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("zaza");
        WalkBird walkBird = new WalkBird();
        flyBird.mainMoveMode("tits");
    }
}
