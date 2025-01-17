package com.foro_hub.api.domain.topicos;

import com.foro_hub.api.domain.topicos.dto.TopicoActualizarDto;
import com.foro_hub.api.domain.topicos.dto.TopicoRegistroDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@EqualsAndHashCode(of = "id")
public class Topicos {
    public Topicos() {
    }

    public Topicos(Long id, String titulo, String mensaje, LocalDateTime fechacreacion, Status status, String autor, String curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechacreacion = fechacreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechacreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;


    public Topicos(TopicoRegistroDto registroDto) {
        this.titulo = registroDto.titulo();
        this.mensaje = registroDto.mensaje();
        this.fechacreacion = LocalDateTime.now();
        this.status = Status.ABIERTO;
        this.autor = registroDto.autor();
        this.curso = registroDto.curso();
    }

    public void actualizarTopico(TopicoActualizarDto topicoActualizarDto){

        if (topicoActualizarDto.titulo() != null){
            this.titulo = topicoActualizarDto.titulo();
        }
        if (topicoActualizarDto.mensaje() != null){
            this.mensaje = topicoActualizarDto.mensaje();
        }
        if (topicoActualizarDto.status() != null){
            this.status = Status.valueOf(topicoActualizarDto.status());
        }
        if (topicoActualizarDto.autor() != null){
            this.autor = topicoActualizarDto.autor();
        }
        if (topicoActualizarDto.curso() != null){
            this.curso = topicoActualizarDto.curso();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechacreacion;
    }

    public Status getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }
}