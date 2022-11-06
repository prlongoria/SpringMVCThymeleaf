package mx.com.gm.HelloThymeleaf.domain;


import lombok.Data;

@Data //esto me agrega el constructor vacío, el método equals, hashcode, getter, setters, toString, es decir, mete todo
// el cóodigo necesario para que mi clase sea un Javabean ysólo necesito meterle los atributos para poder utilizarla
// en el controlador

public class Person {
    //Atributos:
    private String  name;
    private String  surname;
    private String  email;
    private String  phone;

}
