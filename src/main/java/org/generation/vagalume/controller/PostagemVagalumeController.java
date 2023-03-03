package org.generation.vagalume.controller;

/*import java.time.LocalDateTime;*/
/*import java.time.format.DateTimeFormatter;*/
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.vagalume.model.PostagemVagalume;
import org.generation.vagalume.repository.PostagemVagalumeRepository;
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
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemVagalumeController {
	@Autowired
	private PostagemVagalumeRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<PostagemVagalume>> gettAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostagemVagalume> getById(@PathVariable Long id) {
		return postagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	/*@GetMapping("/data/{datapostagem}")
	public String datapostagem() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
		return agora.format(formatar);
	}*/

	@GetMapping("/postagem/{postagemtexto}")
	public ResponseEntity<List<PostagemVagalume>> getPostagemtexto(@PathVariable String postagemtexto) {
		return ResponseEntity.ok(postagemRepository.findAllByPostagemtextoContainingIgnoreCase(postagemtexto));
	}

	@PostMapping
	public ResponseEntity<PostagemVagalume> post(@Valid @RequestBody PostagemVagalume postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<PostagemVagalume> put(@Valid @RequestBody PostagemVagalume postagem) {
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<PostagemVagalume> postagem = postagemRepository.findById(id);

		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		postagemRepository.deleteById(id);
	}
}
