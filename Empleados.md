# Ejercicio Empleados

* **Clase _Empleado_ con método _main_**
```Java
public class Empleado {

	private String nombre;

	public Empleado() {

	}

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado " + nombre;
	}

	public static void main(String[] args) {

		Empleado E1 = new Empleado("Rafa");
		Directivo D1 = new Directivo("Mario");
		Operario OP1 = new Operario("Alfonso");
		Oficial OF1 = new Oficial("Luis");
		Tecnico T1 = new Tecnico("Pablo");
		System.out.println(E1);
		System.out.println(D1);
		System.out.println(OP1);
		System.out.println(OF1);
		System.out.println(T1);
	}
}
```

* **Clase _Directivo_**

```Java
public class Directivo extends Empleado {

	public Directivo() {
		
	}

	public Directivo(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Directivo ";
	}	
}
```

* **Clase _Operario_**

```Java
public class Operario extends Empleado {

	public Operario() {
		
	}
	
	public Operario(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Operario ";
	}	
}
```
* **Clase _Oficial_**

```Java
public class Oficial extends Operario {
	
	public Oficial() {
		
	}

	public Oficial(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Oficial ";
	}	
}
```

* **Clase _Tecnico_**

```Java
public class Tecnico extends Operario {
	
	public Tecnico() {
		
	}
	
	public Tecnico(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Técnico ";
	}
}
```
