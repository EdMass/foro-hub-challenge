package com.foro_hub.api.controller;

import com.foro_hub.api.domain.ValidacionException;
import com.foro_hub.api.domain.topicos.TopicoRepository;
import com.foro_hub.api.domain.topicos.Topicos;
import com.foro_hub.api.domain.topicos.dto.TopicoActualizarDto;
import com.foro_hub.api.domain.topicos.dto.TopicoRegistroDto;
import com.foro_hub.api.domain.topicos.dto.TopicoRespuestaDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<TopicoRespuestaDto> guardarTopico(
            @RequestBody @Valid TopicoRegistroDto registroDto,
            UriComponentsBuilder uriComponentsBuilder){
        Topicos topicos = topicoRepository.save( new Topicos(registroDto));

        TopicoRespuestaDto topicoRespuestaDto = new TopicoRespuestaDto(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFechaCreacion(),
                topicos.getStatus().toString(),
                topicos.getCurso(),
                topicos.getCurso()
        );
        URI url =uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(url).body(topicoRespuestaDto);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoRespuestaDto>> listarTopico(@PageableDefault(size=10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(TopicoRespuestaDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoRespuestaDto> retornarDetallesTopico(@PathVariable Long id){
        if (topicoRepository.findById(id).isEmpty()){
            throw new ValidacionException("No existe topico para ese id");
        }

        if (id <= 0) {
            throw  new ValidacionException("Id invalido");
        }

        var topico = topicoRepository.getReferenceById(id);

        var detallesTopico = new TopicoRespuestaDto(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus().name(), topico.getAutor(), topico.getCurso());

        return ResponseEntity.ok(detallesTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicoActualizarDto> actualizarTopico(@RequestBody @Valid TopicoActualizarDto topicoActualizarDto){
        System.out.println("consultar topico a actualizar");
        Topicos topicos = topicoRepository.getReferenceById(topicoActualizarDto.id());

        topicos.actualizarTopico(topicoActualizarDto);

        var detallesActualizarTopico = new TopicoActualizarDto(topicos.getId(), topicos.getTitulo(), topicos.getMensaje(),
                topicos.getStatus().name(), topicos.getAutor(), topicos.getCurso());

        return ResponseEntity.ok(detallesActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        if (topicoRepository.findById(id).isEmpty()){
            throw new ValidacionException("No existe el topico a borrar");
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
