package ihsanudin;

public class GameCharacter {
    private String name;
    private int lifePoint, attackHitPoint, attackKickPoint;

    public GameCharacter(String name, int attackHitPoint, int attackKickPoint){
        this.name = name;
        this.lifePoint = 100;
        this.attackHitPoint = attackHitPoint;
        this.attackKickPoint = attackKickPoint;
    }

    public String getName(){
        return name;
    }

    public int getLifePoint(){
        return lifePoint;
    }

    void hit(GameCharacter karB){
        karB.lifePoint -= this.attackHitPoint;
    }

    void kick(GameCharacter karB){
        karB.lifePoint -= this.attackKickPoint;
    }

    public static void main(String[] args) {
        GameCharacter raiden = new GameCharacter("Raiden", 10,20);
        GameCharacter subZero = new GameCharacter("SubZero", 5, 25);

        //raiden kick subzero
        raiden.kick(subZero);
        //subzero kick raiden
        subZero.kick(raiden);
        //subzero menyerang raiden dengan pukulan sebanyak 3x
        //kita menggunakan perulangan pada pukulan ini
        for (int i = 0; i < 3; i++) {
            subZero.hit(raiden);
        }
        //raiden melakukan tendangan sebanyak 4x
        for (int i = 0; i < 4; i++) {
            raiden.kick(subZero);
        }

        System.out.println("Life point raiden = "+ raiden.getLifePoint());
        System.out.println("Life point subzero = "+ subZero.getLifePoint());
        System.out.println("------------------------------------------");
        //membuat perulangan untuk menentukan pemenang
        if (raiden.getLifePoint() > subZero.getLifePoint()){
            System.out.println("Pemenangnya = "+raiden.getName());
        }else if (subZero.getLifePoint() > raiden.getLifePoint()){
            System.out.println("Pemenangnya = "+subZero.getName());
        }else {
            System.out.println("PERMAINAN DRAW");
        }
    }
}
