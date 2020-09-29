package view;

import controller.Cozinha;

public class Main {

	public static void main(String[] args) {
		String nome = "";
		int tempo = 0;
		
		for (int i=1; i<6; i++){
			if (i % 2 != 0){
				nome = "Sopa de Cebola";
				tempo = (int) (Math.random() * 300) + 500;
				Thread prato = new Cozinha(i, nome, tempo);
				prato.start();
			}
		}
		
	}

}
