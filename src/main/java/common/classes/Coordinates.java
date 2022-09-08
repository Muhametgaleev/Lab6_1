package common.classes;

public class Coordinates {
    public Coordinates(Float x, Long y){
        this.x=x;
        this.y=y;
    }
    private Float x; //Значение поля должно быть больше -342, Поле не может быть null
    private Long y; //Максимальное значение поля: 809, Поле не может быть null

    public Float getX() {
        return x;
    }

    public Long getY() {
        return y;
    }
}
