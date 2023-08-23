package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Column
    private String model;
    @Column
    private String series;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public Car() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "Model = " + model +
                ", series = " + series;
    }
}
