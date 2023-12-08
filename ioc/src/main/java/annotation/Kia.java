package annotation;

import org.springframework.stereotype.Component;

@Component("kia")
public class Kia implements CarMaker {
@Override
    public Car sell(Money money) {
        System.out.println("기아 자동차 돈주면 차를 팝니다." + money.getAmount());
        Car car = new Car("K9");
        System.out.println("기아에서 만든 "+car.getName());
        return car;
    }
}