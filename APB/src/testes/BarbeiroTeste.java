package testes;

import static org.junit.Assert.*;
import exception.BarbeiroException;
import model.Barbeiro;

import org.junit.Test;

public class BarbeiroTeste {

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirNomeNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setNome(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCPFNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setCpf(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirRGNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setRg(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirTelefoneNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setTelefone(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCadeiraNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setCadeira(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}


