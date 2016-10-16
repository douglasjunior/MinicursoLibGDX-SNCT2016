package com.minicurso.libgdx.gdxgame.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Classe reponsável por armazenar os recursos utilizados no jogo.
 * Created by Douglas on 14/05/2016.
 */
public class Recursos {

    // guarda uma cópia de todos os recursos para facilitar destruílos no final
    Array<Disposable> todosRecursos = new Array<Disposable>();

    // Texturas com animação
    public Array<Texture> txPersonagemAtirando;
    public Array<Texture> txPersonagemCorrendo;
    public Array<Texture> txPersonagemDeslizando;
    public Array<Texture> txPersonagemMorto;
    public Array<Texture> txPersonagemParado;
    public Array<Texture> txPersonagemPulando;
    public Array<Texture> txPersonagemTiro;
    public Array<Texture> txExplosao;
    // Texturas fixas
    public Texture txAbacaxi;
    public Texture txCenoura;
    public Texture txChao;
    public Texture txDonut;
    public Texture txFritas;
    public Texture txFundo;
    public Texture txLanche;
    public Texture txMaca;
    public Texture txMelancia;
    public Texture txMorango;
    public Texture txPizza;
    // Áudios e músicas
    public Music msMenu;
    public Music msJogo;
    public Sound smExplosao;
    public Sound smGameover;
    public Sound smPasso;
    public Sound smTiro;

    /**
     * Inicia todos os recursos utilizados no jogo, texturas, músicas, etc...
     */
    public void iniciarRecursos() {
        iniciarTexturas();
        initAudios();
    }

    /**
     * Carrega todos os arquivos de áudio do jogo
     */
    private void initAudios() {
        msMenu = criarMusica(Gdx.files.internal("audio/menu.mp3"));
        msJogo = criarMusica(Gdx.files.internal("audio/jogo.mp3"));
        smExplosao = criarSom(Gdx.files.internal("audio/explosao.ogg"));
        smGameover = criarSom(Gdx.files.internal("audio/gameover.ogg"));
        smPasso = criarSom(Gdx.files.internal("audio/passo.ogg"));
        smTiro = criarSom(Gdx.files.internal("audio/tiro.ogg"));
    }

    /**
     * Carrega todas as texturas utilizadas no jogo.
     */
    private void iniciarTexturas() {
        txPersonagemAtirando = carregarTexturas("personagem/atirando");
        txPersonagemCorrendo = carregarTexturas("personagem/correndo");
        txPersonagemDeslizando = carregarTexturas("personagem/deslizando");
        txPersonagemMorto = carregarTexturas("personagem/morto");
        txPersonagemParado = carregarTexturas("personagem/parado");
        txPersonagemPulando = carregarTexturas("personagem/pulando");
        txPersonagemTiro = carregarTexturas("personagem/tiro");

        txExplosao = carregarTexturas("explosao");

        txAbacaxi = criarTextura(Gdx.files.internal("cenario/abacaxi.png"));
        txCenoura = criarTextura(Gdx.files.internal("cenario/cenoura.png"));
        txChao = criarTextura(Gdx.files.internal("cenario/chao.png"));
        txDonut = criarTextura(Gdx.files.internal("cenario/donut.png"));
        txFritas = criarTextura(Gdx.files.internal("cenario/fritas.png"));
        txFundo = criarTextura(Gdx.files.internal("cenario/fundo.png"));
        txLanche = criarTextura(Gdx.files.internal("cenario/lanche.png"));
        txMaca = criarTextura(Gdx.files.internal("cenario/maca.png"));
        txMelancia = criarTextura(Gdx.files.internal("cenario/melancia.png"));
        txMorango = criarTextura(Gdx.files.internal("cenario/morango.png"));
        txPizza = criarTextura(Gdx.files.internal("cenario/pizza.png"));
    }

    /**
     * Percorre todos os arquivos da pasta e carrega como Texture
     *
     * @param pasta
     * @return
     */
    private Array<Texture> carregarTexturas(String pasta) {
        Array<Texture> imagens = new Array<Texture>();
        // recupera os arquivos da pasta
        FileHandle[] arquivos = Gdx.files.internal(pasta).list();
        // percorre os arquivos para carregar as texturas
        for (FileHandle arquivo : arquivos) {
            Texture textura = criarTextura(arquivo);
            imagens.add(textura);
        }
        return imagens;
    }

    /**
     * Cria um objeto Texture a partir de um arquivo
     *
     * @param arquivo
     * @return
     */
    private Texture criarTextura(FileHandle arquivo) {
        Texture textura = new Texture(arquivo);
        // armazena o recurso na lista para ser destruido no final
        todosRecursos.add(textura);
        return textura;
    }

    /**
     * Cria um objeto Music a partir de um arquivo
     *
     * @param arquivo
     * @return
     */
    private Music criarMusica(FileHandle arquivo) {
        Music musica = Gdx.audio.newMusic(arquivo);
        // armazena o recurso na lista para ser destruido no final
        todosRecursos.add(musica);
        return musica;
    }

    /**
     * Cria um objeto Sound a partir de um arquivo
     *
     * @param arquivo
     * @return
     */
    private Sound criarSom(FileHandle arquivo) {
        Sound som = Gdx.audio.newSound(arquivo);
        // armazena o recurso na lista para ser destruido no final
        todosRecursos.add(som);
        return som;
    }

    /**
     * Destroi todos os recursos carregados
     */
    public void destruirRecursos() {
        for (Disposable recurso : todosRecursos) {
            recurso.dispose();
        }
    }

}
