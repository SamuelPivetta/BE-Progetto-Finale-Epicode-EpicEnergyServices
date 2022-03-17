package it.epicode.be.energy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.test.context.support.WithAnonymousUser;

import org.springframework.test.web.servlet.MockMvc;

import it.epicode.be.energy.model.Cliente;
import it.epicode.be.energy.model.Comune;
import it.epicode.be.energy.model.Indirizzo;
import it.epicode.be.energy.model.Provincia;

@AutoConfigureMockMvc
@SpringBootTest
class EpicEnergyServicesApplicationTests {


	
	
	@Autowired
	private MockMvc mockMvc;
	
	Cliente cliente;
	Indirizzo sedeLegale;
	Indirizzo sedeOperativa;
	Comune comune;
	Provincia provincia;
	
	@Test
	@WithAnonymousUser
	public void loginSenzaBody() throws Exception {
		this.mockMvc.perform(post("/auth/login")).andExpect(status().isBadRequest());
	}

	@Test
	@WithAnonymousUser
	public void testAllClienti() throws Exception {
		this.mockMvc.perform(get("/api/cliente")).andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithAnonymousUser
	public void testAllFatture() throws Exception {
		this.mockMvc.perform(get("/api/fattura")).andExpect(status().isUnauthorized());
	}
	
	
	@BeforeEach
	public void initContext() {
	cliente = new Cliente();
	cliente.setRagioneSociale("ClienteJUnit");
	cliente.setPartitaIva("IE557059");
	cliente.setEmail("mail@junit.it");
	LocalDate dateIns = LocalDate.of(2020, 1, 8);
	cliente.setDataInserimento(dateIns);
	LocalDate dateLast = LocalDate.of(2022, 5, 10);
	cliente.setDataUltimoContatto(dateLast);
	BigDecimal fatturato =new BigDecimal(450093);
	cliente.setFatturatoAnnuale(fatturato);
	cliente.setPec("test@pec.it");
	cliente.setTelefono("3499443895");
	cliente.setEmailContatto("testcontatto@mail.it");
	cliente.setNomeContatto("Test");
	cliente.setCognomeContatto("Test");
	cliente.setTelefonoContatto("3398865032");
	
	sedeLegale = new Indirizzo();
	sedeLegale.setVia("Via Alessandria");
	sedeLegale.setCivico(43);
	sedeLegale.setLocalita("Bolzano");
	sedeLegale.setCap(39100L);
	
	sedeOperativa = new Indirizzo();
	sedeOperativa.setVia("Via Roma");
	sedeOperativa.setCivico(12);
	sedeOperativa.setLocalita("Roma");
	sedeOperativa.setCap(43568L);
	
	provincia = new Provincia();
	provincia.setNome("Bolzano");
	provincia.setRegione("Trentino Alto Adige");
	provincia.setSigla("BZ");
	
	comune = new Comune();
	comune.setNome("Bronzolo");
	comune.setProvincia(provincia);
	
	}
	
	
}
