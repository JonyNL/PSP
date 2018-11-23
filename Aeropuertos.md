* **Clase Aeropuerto**
```Java
public class Aeropuerto {

	private int id;
	private String nombre;
	private String poblacion;
	private String pais;
	private String acron;
	private double[] coordenadas = new double[2];

	public Aeropuerto(String[] vars) {
		this.id = Integer.parseInt(vars[0]);

		if (vars.length == 14) {
			this.nombre = vars[1];
			this.poblacion = vars[2];
			this.pais = vars[3];
			this.acron = vars[4];
			this.coordenadas[0] = Double.parseDouble(vars[6]);
			this.coordenadas[1] = Double.parseDouble(vars[7]);
		} else {
			this.nombre = vars[1] + ", " + vars[2];
			this.poblacion = vars[3];
			this.pais = vars[4];
			this.acron = vars[5];
			this.coordenadas[0] = Double.parseDouble(vars[7]);
			this.coordenadas[1] = Double.parseDouble(vars[8]);
		}

	}

	@Override
	public String toString() {
		
		return "Nombre: " + this.nombre + " - Población: " + this.poblacion + " - País: " + this.pais;
		// + ", " + this.acron + ", " + this.coordenadas[0] + ", " + this.coordenadas[1] + ". ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAcron() {
		return acron;
	}

	public void setAcron(String acron) {
		this.acron = acron;
	}

	public double[] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(double[] coordenadas) {
		this.coordenadas = coordenadas;
	}
}
```  

* **Clase VentanaAeropuertos**
```Java
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAeropuertos {

	private JFrame frame;
	private JTextField tfPoblacion;
	private static JComboBox<Aeropuerto> cbAeropuertos;
	private static ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();

	/**
	 * Launch the application.
	 */

	public static void buscarAeropuertos(String poblacion) {

		for (Aeropuerto aeropuerto : aeropuertos) {
			if (aeropuerto.getPoblacion().contains(poblacion))
				cbAeropuertos.addItem(aeropuerto);
		}
	}

	public static void main(String[] args) {

		try {
			File file = new File("Aeropuertos.dat");

			BufferedReader br;

			if (!file.exists()) {
				URL url = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				BufferedReader brU = new BufferedReader(new InputStreamReader(url.openStream()));
				String lineURL = null;
				while ((lineURL = brU.readLine()) != null) {
					bw.write(lineURL);
					bw.newLine();

				}
				bw.close();
			}

			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				aeropuertos.add(new Aeropuerto(line.split(",")));
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (MalformedURLException e3) {
			e3.printStackTrace();

		} catch (IOException e2) {
			e2.printStackTrace();

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAeropuertos window = new VentanaAeropuertos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAeropuertos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 216);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAeropuertos = new JLabel("Aeropuertos");
		lblAeropuertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAeropuertos.setFont(new Font("Arial", Font.BOLD, 18));
		lblAeropuertos.setBounds(10, 11, 386, 33);
		frame.getContentPane().add(lblAeropuertos);

		tfPoblacion = new JTextField();
		tfPoblacion.setBounds(139, 68, 86, 20);
		frame.getContentPane().add(tfPoblacion);
		tfPoblacion.setColumns(10);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n: ");
		lblPoblacion.setBounds(53, 71, 66, 14);
		frame.getContentPane().add(lblPoblacion);

		cbAeropuertos = new JComboBox<Aeropuerto>();
		cbAeropuertos.setBounds(10, 102, 386, 20);
		frame.getContentPane().add(cbAeropuertos);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbAeropuertos.removeAllItems();
				buscarAeropuertos(tfPoblacion.getText());
			}
		});
		btnBuscar.setBounds(276, 67, 89, 23);
		frame.getContentPane().add(btnBuscar);

		JButton btnGoogle = new JButton("Buscar en Google Maps");
		btnGoogle.setBounds(10, 133, 186, 33);
		frame.getContentPane().add(btnGoogle);
		btnGoogle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aeropuerto a = (Aeropuerto) cbAeropuertos.getSelectedItem();
				try {
					Desktop.getDesktop().browse(new URI(
							"https://www.google.com/maps/?q=" + a.getCoordenadas()[0] + "," + a.getCoordenadas()[1]));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error en la busqueda.");
					// e1.printStackTrace();
				} catch (NullPointerException e2) {
					System.out.println("No se ha seleccionado aeropuerto.");
				} catch (URISyntaxException e3) {
					System.out.println("Error en la dirección URL.");
				}

			}
		});

		JButton btnOSM = new JButton("Buscar en OpenStreetMap");
		btnOSM.setBounds(210, 133, 186, 33);
		frame.getContentPane().add(btnOSM);
		btnOSM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aeropuerto a = (Aeropuerto) cbAeropuertos.getSelectedItem();
				try {
					Desktop.getDesktop().browse(new URI("http://www.openstreetmap.org/?mlat=" + a.getCoordenadas()[0]
							+ "&mlon=" + a.getCoordenadas()[1] + "&zoom=12"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error en la busqueda.");
					// e1.printStackTrace();
				} catch (NullPointerException e2) {
					System.out.println("No se ha seleccionado aeropuerto.");
				} catch (URISyntaxException e3) {
					System.out.println("Error en la dirección URL.");
				}

			}
		});
	}
}
```
