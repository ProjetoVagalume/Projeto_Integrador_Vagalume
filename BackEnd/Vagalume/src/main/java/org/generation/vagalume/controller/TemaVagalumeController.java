package org.generation.vagalume.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.vagalume.model.TemaVagalume;
import org.generation.vagalume.repository.TemaVagalumeRepository;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaVagalumeController {
	


		@Autowired
		private TemaVagalumeRepository temaVagalumeRepository;
		
		@GetMapping
		public ResponseEntity<List<TemaVagalume>> GetAll(){
			return ResponseEntity.ok(temaVagalumeRepository.findAll());
		}
		@GetMapping("/{Id}")
		public ResponseEntity<TemaVagalume> getById(@PathVariable Long id){
			return temaVagalumeRepository.findById(id)
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
		@GetMapping("/tipodescricao/{tipodescricao}")
		public ResponseEntity<List<TemaVagalume>>getBytipodescricao(@PathVariable String tipodescricao){
			return ResponseEntity.ok(temaVagalumeRepository.findAllByTipodescricaoContainingIgnoreCase(tipodescricao));
		}
		
		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<TemaVagalume>>getBydescricao(@PathVariable String descricao){
			return ResponseEntity.ok(temaVagalumeRepository.findAllByDescricaoContainingIgnoreCase(descricao));
		}
		
		@PostMapping
		public ResponseEntity<TemaVagalume> post (@Valid @RequestBody TemaVagalume TemaVagalume){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(temaVagalumeRepository.save(TemaVagalume));		
		}
		@PutMapping
		public  ResponseEntity<TemaVagalume> put(@Valid @RequestBody TemaVagalume TemaVagalume){
			return temaVagalumeRepository.findById(TemaVagalume.getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK)
							.body(temaVagalumeRepository.save(TemaVagalume)))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
			
		}
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete (@PathVariable Long id) {
			Optional<TemaVagalume> TemaVagalume = temaVagalumeRepository.findById(id);
			
			if(TemaVagalume.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			temaVagalumeRepository.deleteById(id);
			
		}
	}