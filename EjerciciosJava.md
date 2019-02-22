# PSP
## Ejercicios Java
### Elementos y conceptos:
* **Clase**

Una clase en java es una plantilla o prototipo para la creación de objetos.  
Indica las propiedades y métodos de los que dispondrá cada una de sus instancias.

**Ejemplo**
```Java
class Lamp {

  // variable de instancia
  private boolean isOn;

  // método
  public void turnOn() {
    isOn = true;
  }
  // método
  public void turnOff() {
    isOn = false;
  }
}

```


* **Objeto**

Un objeto es una instancia creada a partir de una clase.  
Las instancias de una clase comparten los métodos y las variables, pero cada objeto tiene valores propios para estas
últimas, lo que significa que aunque sean objetos de la misma clase, puede variar el estado de sus variables.

**Ejemplo**
```Java
class ClassObjectsExample {
  public static void main(String[] args) {
    Lamp l1 = new Lamp(); // Creamos el objeto l1 de la clase Lamp.
    Lamp l2 = new Lamp(); // Creamos el objeto l2 de la clase Lamp.
  }
}
```


* **Sobrecarga de métodos**

La sobrecarga de métodos te permite indicar diferentes formas de implementar un método dependiendo de la cantidad y tipo de
parámetros que esté recibiendo cuando se ejecuta.  
Funciona de la misma manera para los constructores de una clase.

**Ejemplo**  
Por ejemplo si fueramos a crear más de un constructor para la clase *Lamp* del ejemplo anterior, podríamos añadir lo siguiente
en la clase: 

```Java
// Constructor vacío
public Lamp() {

}
// Constructor con parámetro recibido
public Lamp(boolean isOn) {
  this.isOn = isOn;
}
```


* **Herencia**

La herencia consiste en una clase que hereda variables y métodos de otra, que es considerada la *super clase*.  
Esto nos permite crear una clase desde la que poder usar todos los metodos y variables de otra sin tener que
volver a crearlos.

**Ejemplo**

Si nos basamos en la siguiente clase:
```Java
class Furnishing {
  \\ Variables de instancia
  private double price;
  private String color;
  
  \\ Método Setter
  public void setPrice(double prc) {
    price = prc;
  }
   \\ Método Getter
  public String getColor() {
    return color;
  }
}
```

Y en la creacion de la clase *Lamp* previamente creada añadimos lo siguiente:
```Java
class Lamp extends Furnishing {
\\ ...
}
```

Podremos hacer esto:
```Java
// Usando los ejemplos de Objetos anteriores
// Usamos el método setPrice() de la super clase Furnishing 
l1.setPrice(14.95);
// Imprimimos el color con el método de la super clase
System.out.print(l2.getColor());
```


* **Polimorfismo**

El polimorfismo es una característica de la programación orientada a objetos que nos permite realizar una misma acción de
formas diferentes dependiendo de que clase la implemente.

**Ejemplo**  
Si en nuestra super clase *Furnishing* creada anteriormente implementamos un método para calcular un precio de transporte genérico,
pero también queremos poner precios específicos dependiendo del elemento transportado, podemos hacer:  
En la super clase
```Java
class Furnishing {
  // ...
  // Creamos el método en la super clase
  public double transportPrice() {
    return price * 0.5; // Por ejemplo, de forma genérica, el precio de transporte equivale a la mitad del precio del artículo.
  }
}
```

Y en la sub clase
```Java
class Lamp extends Furnishing {
  // ...
  // Creamos el método nuevamente en la sub clase añadiendo la etiqueta @Override
  @Override
  public double transportPrice() {
    return price * 0.25; // En el caso de la lámpara, ya que es un artículo fácil de transportar, su precio es menor.
  }
}

```


* **Interface**

Las interfaces son más o menos una plantilla que incluye la cabecera de los metodos que las subclases tienen que implementar. También
puede incluir variables finales o constantes que serían accesibles por otras clases.

