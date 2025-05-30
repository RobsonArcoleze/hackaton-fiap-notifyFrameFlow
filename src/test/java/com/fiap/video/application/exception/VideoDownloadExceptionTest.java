package com.fiap.video.application.exception;

import com.fiap.video.application.exception.VideoDownloadException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoDownloadExceptionTest {

    @Test
    void deveCriarExcecaoComMensagemECausa() {
        Throwable causa = new RuntimeException("Erro original");
        VideoDownloadException exception = new VideoDownloadException("Erro ao baixar vídeo", causa);

        assertEquals("Erro ao baixar vídeo", exception.getMessage());
        assertEquals(causa, exception.getCause());
    }
}
