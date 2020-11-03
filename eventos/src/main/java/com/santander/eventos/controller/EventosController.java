package com.santander.eventos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santander.eventos.Exceptions.FormatoDataErradoException;
import com.santander.eventos.model.Eventos;
import com.santander.eventos.repository.EventosRepository;


@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventosController {
	
	@Autowired
	private EventosRepository eRepository;
	
	@GetMapping
	public ResponseEntity<List<Eventos>> GetAll(){
		return ResponseEntity.ok(eRepository.findAll());
	}

	@GetMapping("/{idEvento}")
	public ResponseEntity<Eventos> GetById(@PathVariable Long idEvento){
		return eRepository.findById(idEvento)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Eventos>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(eRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Eventos> post(@RequestBody Eventos eventos){
		return ResponseEntity.status(HttpStatus.CREATED).body(eRepository.save(eventos));	
	}
	
	@PutMapping
	public ResponseEntity<Eventos> put(@RequestBody Eventos eventos){
		return ResponseEntity.status(HttpStatus.OK).body(eRepository.save(eventos));
	}
	
	
	@DeleteMapping("/{idEvento}")
	public void delete(@PathVariable Long idEvento) {
		eRepository.deleteById(idEvento);
	}
	
	@GetMapping("/eventosproximos")
	public List<Eventos> GetEventosDatas(@RequestParam(value="inicioEvento", required = true) String inicioEvento,
											@RequestParam(value="fimEvento",required = true) String fimEvento){
		Date dataInicio = null;
		Date dataFinal = null;
		
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			dataInicio = formatoData.parse(inicioEvento);
		} catch(ParseException e) {
			throw new FormatoDataErradoException("Data inicial inserida erroneamente: "+inicioEvento);
		}
		
		try {
			dataFinal = formatoData.parse(fimEvento);
		} catch(ParseException e) {
			throw new FormatoDataErradoException("Data final inserida erroneamente: "+fimEvento);
		}
		
		LocalDateTime inicioData = LocalDateTime.ofInstant(dataInicio.toInstant(),
				ZoneId.systemDefault());
		
		LocalDateTime finalData = LocalDateTime.ofInstant(dataFinal.toInstant(),
				ZoneId.systemDefault());
		
		return eRepository.findByDataInicioAndDataFinal(inicioData, finalData);
		
	}
	
}
