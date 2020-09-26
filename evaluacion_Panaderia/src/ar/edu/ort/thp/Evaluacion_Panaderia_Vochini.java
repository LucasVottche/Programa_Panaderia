package ar.edu.ort.thp;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Evaluacion_Panaderia_Vochini {
	public static final String MEDIALUNA="MEDIALUNA";
	public static final String CHIPA="CHIPA";
	public static final String ROSCA="ROSCA";
	public static final String ALFAJOR ="ALFAJOR";
	public static final String OP1 ="s";
	public static final String OP2 ="n";
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String dni;
		String ingreso = "";
		String otroProducto = "";
		int cantProductos=0;
		double precioProducto=0;
		int cantidadVentasDia=0;
		double ventaDiaria=0;
		double recaudacionTotal=0;
		double ventaProm=0;
		double ventaMayor=0;
		String dniMayor="";
		System.out.println("----------------------------------------");
		System.out.println( "BIENVENIDO A LA PANADERIA 9  DE JULIO");
		System.out.println("----------------------------------------");
		dni = ingresoDni();
		System.out.println("----------------------------------------");
		while (!dni.equals("0")) {
			menu();
			do {
				System.out.println("-----------------------------------");
				ingreso=ingresoProducto(ingreso);
				System.out.println("-----------------------------------");
				cantProductos=cantidadProductos(cantProductos);
				System.out.println("-----------------------------------");
				precioProducto=cargaProductos(ingreso,precioProducto,cantProductos);
				System.out.println("-----------------------------------");
				otroProducto=otroProducto(otroProducto);
				System.out.println("-----------------------------------");
				recaudacionTotal=recaudacionTotal+(precioProducto*cantProductos);
			} while (!otroProducto.equals("n"));
			cantidadVentasDia++;
			ventaDiaria=ventaDiaria+recaudacionTotal;
			System.out.println("El importe total de la compra es :"+recaudacionTotal);
			System.out.println("-----------------------------------");
			if(recaudacionTotal>ventaMayor) {
				ventaMayor=recaudacionTotal;
				dniMayor=dni;
			}
			recaudacionTotal=0;
			dni = ingresoDni();
			System.out.println("-----------------------------------");
			System.out.println("Ingreso Finalizado");
		}
		ventaProm=(ventaDiaria/cantidadVentasDia);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Cantidad de ventas realizadas en el día :"+ cantidadVentasDia);
		System.out.println("Recaudación total diaria: "+ ventaDiaria);
		System.out.println("Monto de la venta promedio:" + ventaProm);
		System.out.println("Importe y DNI cliente mejor compra: "+dniMayor + "-" +ventaMayor);
		System.out.println("-----------------------------------------------------------------");

	}

	public static String ingresoDni() {
		String limite;
		System.out.println("Ingrese el dni del cliente (0 para terminar):");
		limite = input.next();
		return validacionDni(limite);
	}

	public static String validacionDni(String limite) {
		int caca = 8;
		while (limite.length() > caca) {
			System.out.println("Error: ingrese nuevamente, DNI =  8 digitos");
			limite = input.next();
		}
		return limite;

	}
	
	
	public static void menu() {
		System.out.println("Los productos ofrecidos son: \n"+"Medialuna :$30 \n"
				+"Chipa: $50 \n" + "Rosca : $350 \n" +"Alfajor :$70 \n"  );
	}
	
	public static String ingresoProducto(String ingreso) {
		System.out.println("Ingrese el producto:");
		ingreso=input.next();
		
		while (!ingreso.equals("MEDIALUNA") && !ingreso.equals("CHIPA") && !ingreso.equals("ROSCA") && !ingreso.equals("ALFAJOR") ) {
			System.out.println("Error: ingrese nuevamente el Producto");
			ingreso=input.next();
		}
		
		return ingreso;
	}
	
	public static int cantidadProductos(int cantProductos) {
		System.out.println("Ingrese la cantidad de Productos :");
		cantProductos=input.nextInt();
		
		while (cantProductos<0) {
			System.out.println("Error:  la cantidad de Productos debe ser mayor a 0 :");
			cantProductos=input.nextInt();
		}
		
		return cantProductos;
	}
	public static String otroProducto(String otroProducto) {
	
		
		do {
			System.out.println("Desea cargar otro producto? (S/N)");
			otroProducto=input.next();
			
		} while ((!otroProducto.equals(OP1)&& !otroProducto.equals(OP2))); 
			
		
		
		return otroProducto;
	}
	
	public static double cargaProductos(String ingreso,double precioProducto,int cantProductos) {
		switch (ingreso) {
		case MEDIALUNA:
			precioProducto=30*cantProductos;
			break;
		case CHIPA:
			precioProducto=50*cantProductos;
			break;
		case ROSCA:
			precioProducto=350*cantProductos;
			break;
		case ALFAJOR:
			precioProducto=70*cantProductos;
			break;
		default:
			break;
		}
		return precioProducto;
	}
}
