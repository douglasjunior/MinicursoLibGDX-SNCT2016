package com.minicurso.libgdx.gdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minicurso.libgdx.gdxgame.telas.TelaJogo;
import com.minicurso.libgdx.gdxgame.util.Recursos;
import com.minicurso.libgdx.gdxgame.util.Util;

public class MainGame extends Game {

    // resolução do jogo em pixels
    public static final int LARGURA_TELA = 640, ALTURA_TELA = 360;

    // objeto que carrega os recursos das texturas e aúdios
    private Recursos recursos;
    // cobjeto responsável por desenhar as texturas e os sprites
    private SpriteBatch batch;
    // objeto que desenha texto (Strings) na tela
    private BitmapFont fonte;

    /**
     * Método chamado quando o jogo é iniciado
     */
    @Override
    public void create() {
        fonte = Util.criarFonte(32);
        batch = new SpriteBatch();
        // define a TelaJogo como tela inicial
        setScreen(new TelaJogo(this));
    }

    /**
     * Método invocado a cada quadro (frame) por segundo.
     * <p>
     * Se este método é chamado 60 vezes por segundo, então estamos trabalhando com 60 FPS
     */
    @Override
    public void render() {
        // limpa a tela
        Gdx.gl.glClearColor(1, .25f, .25f, .25f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // desenha a tela atual
        super.render();
    }

    /**
     * Método invocado quando o jogo é encerrado.
     * <p>
     * Destroi os recursos criados no início do jogo.
     */
    @Override
    public void dispose() {
        super.dispose();
        fonte.dispose();
        batch.dispose();
        recursos.destruirRecursos();
    }

    public synchronized Recursos getRecursos() {
        if (recursos == null) {
            recursos = new Recursos();
            recursos.iniciarRecursos();
        }
        return recursos;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFonte() {
        return fonte;
    }

}
