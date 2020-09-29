package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread {
	private String nome;
	private int tempo;
	private int id;
	private static Semaphore semaforo = new Semaphore(1);

	public Cozinha(int id, String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		this.id = id;
	}

	public void run() {
		System.out.println("O prato n°" + id + " " + nome + " começou a ser preparado.");
		int termina = 0;
		while (termina < 95) {
			termina = termina + (tempo / 100);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O prato n°" + id + " " + nome + " está " + termina + "% concluído.");
		}
		System.out.println("O prato n°" + id + " " + nome + " está pronto!");

		try {
			semaforo.acquire();
			sleep(75);
			System.out.println("O prato n°" + id + " " + nome + " foi entregue.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
}
