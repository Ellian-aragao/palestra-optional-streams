package aragao.ellian.com.github.slide;

import java.util.Objects;
import java.util.Optional;

public class Slide {
    public class Person {
        private Car car;
        public Car getCar() {
            return car;
        }
    }
    public class Car {
        private Insurance insurance;

        public Insurance getInsurance() {
            return insurance;
        }
    }
    public class Insurance {
        private String name;

        public String getName() {
            return name;
        }
    }

    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public String getCarInsuraceNameSafety(Person person) {
        if (Objects.nonNull(person)) {
            final var car = person.getCar();
            if (Objects.nonNull(car)) {
                final var insurance = car.getInsurance();
                if (Objects.nonNull(insurance)) {
                    return insurance.getName();
                }
            }
        }
        return "unknow";
    }

    public String getCarInsuraceNameSafety2(Person person) {
        if (Objects.isNull(person)) {
            return "unknow";
        }
        final var car = person.getCar();
        if (Objects.isNull(car)) {
            return "unknow";
        }
        final var insurance = car.getInsurance();
        if (Objects.isNull(insurance)) {
            return "unknow";
        }
        return insurance.getName();
    }

    public String getCarInsuraceNameOptional(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknow");
    }
}
