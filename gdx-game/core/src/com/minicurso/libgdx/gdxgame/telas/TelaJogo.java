package com.minicurso.libgdx.gdxgame.telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.minicurso.libgdx.gdxgame.MainGame;
import com.minicurso.libgdx.gdxgame.objetos.Chao;
import com.minicurso.libgdx.gdxgame.objetos.Explosao;
import com.minicurso.libgdx.gdxgame.objetos.Personagem;
import com.minicurso.libgdx.gdxgame.objetos.Tiro;
import com.minicurso.libgdx.gdxgame.obstaculos.Obstaculo;
import com.minicurso.libgdx.gdxgame.obstaculos.Obstaculos;
import com.minicurso.libgdx.gdxgame.util.Recursos;
import com.minicurso.libgdx.gdxgame.util.Util;

import java.util.Iterator;

import static com.minicurso.libgdx.gdxgame.util.Util.PIXEL_METRO;

/**
 * Tela que representa o cenário do jogo.
 * Created by Douglas on 14/05/2016.
 */
public class TelaJogo implements Screen {

    private MainGame game;

    // objeto que define o comportamento da câmera do jogo
    private OrthographicCamera camera;
    private OrthographicCamera cameraPontuacao;
    // objeto que representa o mundo fíciso do jogo, com força da gravidade e colisão
    private World mundo;
    // objeto que carrega os recursos das texturas e aúdios
    private Recursos recursos;
    // cobjeto responsável por desenhar as texturas e os sprites
    private SpriteBatch batch;
    // objeto que desenha texto (Strings) na tela
    private BitmapFont fonte;

    private Personagem personagem;
    private Obstaculos obstaculos;
    private Chao chao;
    private Array<Tiro> tiros = new Array<Tiro>();
    private Array<Explosao> explosoes = new Array<Explosao>();
    private Vector2 posicaoPontuacao;
    private Vector2 posicaoVidas;
    private Vector2 posicaoGameover;

    private boolean reiniciarJogo = false;
    private int pontuacao = 0;
    private int vidas = 3;

    // objeto que imprime o contorno dos corpos na tela (utilizado para debug)
    private Box2DDebugRenderer debug;

    private float atrasoTiro = 0;

    public TelaJogo(MainGame game) {
        this.game = game;
    }

    /**
     * Método chamado quando a tela é exibida a primeira vez
     */
    @Override
    public void show() {
        batch = game.getBatch();
        recursos = game.getRecursos();
        fonte = game.getFonte();

        initCamera();
        initMundo();
        initPersonagem();
        initObstaculos();
        initMusica();
        initTextos();
    }

    /**
     * Método invocado a cada quadro (frame) por segundo.
     * <p>
     * Se este método é chamado 60 vezes por segundo, então estamos trabalhando com 60 FPS
     */
    @Override
    public void render(float delta) {
        atualizar(delta);
        desenhar();

        // verifica se o jogo deve ser reiniciado
        if (reiniciarJogo) {
            // cria uma nova tela de jogo
            game.setScreen(new TelaJogo(game));
        }
    }

    /**
     * Chamado sempre que o jogo é minimizado
     */
    @Override
    public void pause() {

    }

    /**
     * Chamado toda vez que a tela muda de tamanho.
     *
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * Chamado toda vez que o jogo volta ao topo das janelas
     */
    @Override
    public void resume() {

    }

    /**
     * Chamado quando a tela é substituída por outra
     */
    @Override
    public void hide() {
        // quando a tela é substituída o dispose também deve ser invocado
        dispose();
    }

    /**
     * Destroi os recursos criados pela tela
     */
    @Override
    public void dispose() {
        mundo.dispose();
        debug.dispose();
    }

    /**
     * Inicia o objeto da câmera
     */
    private void initCamera() {
        // inicia a câmera geral do jogo
        // IMPLEMENTAR

        // inicia a câmera do texto da pontuação
        // IMPLEMENTAR
    }

    /**
     * Inicia o objeto do mundo físico
     */
    private void initMundo() {
        // cria o mundo físico e configura a gravidade para 200 pixels por segundo
        // IMPLEMENTAR

        // configura o evento que detecta as colisões
        // IMPLEMENTAR

        // cria o objeto para debug para desenhar os objetos do corpo físico
        // IMPLEMENTAR
    }

    /**
     * Cria o personagem e o chão
     */
    private void initPersonagem() {
        // instancia o objeto que controla o personagem
        // IMPLEMENTAR

        // instancia o objeto que controla o chao
        // IMPLEMENTAR
    }

    /**
     * Cria o objeto responsável por controlar os obstáculos
     */
    private void initObstaculos() {
        // instancia o objeto que controla os obstáculos
        // IMPLEMENTAR
    }

    /**
     * Inicia as músicas que tocarão durante o jogo
     */
    private void initMusica() {
        // configura e inicia a música de abertura
        // IMPLEMENTAR

        // configura a música de gameplay, mas não inicia por enquanto
        // IMPLEMENTAR
    }

    /**
     * Inicia a posição dos textos
     */
    private void initTextos() {
        // define a posição da pontuação
        // IMPLEMENTAR

        // define a posição das vidas
        // IMPLEMENTAR

        // define a posição do Gameover
        // IMPLEMENTAR
    }

    /**
     * Identifica qual a colisão que ocorreu no mundo físico
     *
     * @param contato
     */
    private void detectouColisao(Contact contato) {
        if (Util.colidiu(contato, Tiro.class, Obstaculo.class)) {
            colisaoTiroObstaculo(contato);
        } else if (Util.colidiu(contato, Personagem.class, Obstaculo.class)) {
            colisaoPersonagemObstaculo(contato);
        }
    }

    private void colisaoPersonagemObstaculo(Contact contato) {
        // verifica qual o objeto corresponde ao obstáculo, A ou B
        // IMPLEMENTAR

        // se a pontuação do obstáculo é zero, então decrementa a vida, senão soma a pontuação
        // IMPLEMENTAR

        // marca o obstáculo para ser destruído
        // IMPLEMENTAR
    }

    /**
     * Transfere o personagem para MORTO
     */
    private void gameOver() {
        // verifica se o personagem já está morto, se não está então mata-o e para a música
        // IMPLEMENTAR
    }

    /**
     * Evento de colisão entre o tiro e um obstaculo qualquer
     *
     * @param contact
     */
    private void colisaoTiroObstaculo(Contact contact) {
        // verifica se o tiro e o obstáculo estão no o objeto A ou B
        // IMPLEMENTAR

        // cria a explosão e marca o tiro e o obstáculo para serem destruídos
        // IMPLEMENTAR
    }

    /**
     * Cria o efeito de explosão
     *
     * @param obstaculo
     */
    private void criarExplosao(Obstaculo obstaculo) {
        // define a posição da explosão
        // IMPLEMENTAR

        // cria o objeto que representa a explosão, adiciona na lista e executa o efeito sonoro
        // IMPLEMENTAR
    }

    /**
     * Chamado a cada quadro por segundo para desenhar os recursos na tela
     */
    protected void desenhar() {
        // inicia o desenho
        batch.begin();

        // configura o batch de acordo com tamanho e posição da câmera das pontuações
        batch.setProjectionMatrix(cameraPontuacao.combined);
        desenharFundo();
        desenharTextos();

        // configura o batch de acordo com o tamanho e posição da câmera do jogo
        batch.setProjectionMatrix(camera.combined);
        desenharObjetos();

        // finaliza o desenho
        batch.end();

        // desenha o debug dos corpos físicos
        // importante criar uma cópia da posição da câmera antes de converser para metros
        debug.render(mundo, camera.combined.cpy().scl(PIXEL_METRO));
    }

    /**
     * Desenha a pontuação, vidas e gameover na tela
     */
    private void desenharTextos() {
        // desenha a pontuação
        fonte.draw(batch, pontuacao + " pontos", posicaoPontuacao.x, posicaoPontuacao.y);
        // desenha as vidas
        fonte.draw(batch, vidas + " vidas", posicaoVidas.x, posicaoVidas.y);
        // desenha gameover e o personagem estiver morto
        if (personagem.getSituacao() == Personagem.MORTO)
            fonte.draw(batch, "GAME OVER", posicaoGameover.x, posicaoGameover.y);
    }

    /**
     * Desenha os objetos na ordem correta
     */
    private void desenharObjetos() {
        // desenha os obstáculos, porsonagem e chao
        // IMPLEMENTAR

        desenharTiros();
        desenharExplosoes();
    }

    /**
     * Desenha as explosões
     */
    private void desenharExplosoes() {
        for (Explosao explosao : explosoes) {
            explosao.desenhar(batch);
        }
    }

    /**
     * Desenha os tiros
     */
    private void desenharTiros() {
        for (Tiro tiro : tiros) {
            tiro.desenhar(batch);
        }
    }

    /**
     * Desenha o fundo de acordo com o tamanho e posição da câmera
     */
    private void desenharFundo() {
        // desenha a imagem de fundo cobrindo a tela toda
        // IMPLEMENTAR
    }

    /**
     * Chamado a cada quadro (frame) por segundo para atualizar os recursos da tela
     *
     * @param delta
     */
    protected void atualizar(float delta) {
        // para PC
        capturarTeclas();
        // para mobile
        capturarToques();

        atualizarCamera();
        atualizarObjetos(delta);

        if (vidas <= 0) {
            gameOver();
        }

        // atualiza o próximo quadro (frame) do mundo
        mundo.step(1f / 60f, 6, 2);
    }

    /**
     * Captura os toques na tela
     */
    private void capturarToques() {
        // verifica se houve o toque na tela
        if (Gdx.input.justTouched()) {
            if (personagem.getSituacao() == Personagem.PARADO) {
                // jogo deve ser inciado
                iniciarJogo();
                return;
            }
            if (personagem.getSituacao() == Personagem.MORTO) {
                // jogo deve ser reiniciado
                reiniciarJogo = true;
                return;
            }
            // verifica se o toque ocorreu na parte superior direita da tela
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 &&
                    Gdx.input.getY() < Gdx.graphics.getHeight() / 2 &&
                    (personagem.getSituacao() == Personagem.CORRENDO ||
                            personagem.getSituacao() == Personagem.ATIRANDO)) {
                personagem.pular();
            }
            // verifica se o toque ocorreu na parte inferior direita da tela
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 &&
                    Gdx.input.getY() >= Gdx.graphics.getHeight() / 2 &&
                    personagem.getSituacao() == Personagem.CORRENDO) {
                personagem.deslizar();
            }
            // verifica se o toque ocorreu na parte esquerda da tela
            if (Gdx.input.getX() <= Gdx.graphics.getWidth() / 2
                    && personagem.getSituacao() == Personagem.CORRENDO) {
                personagem.atirar();
            }
        }
    }

    /**
     * Atualiza todos os objetos do jogo em ordem
     *
     * @param delta
     */
    private void atualizarObjetos(float delta) {
        // atualiza os obstáculos, personagem e o chao
        // IMPLEMENTAR

        //atualizarTiros(delta);
        //atualizarExplosoes(delta);
    }

    /**
     * Atualiza as explosões
     *
     * @param delta
     */
    private void atualizarExplosoes(float delta) {
        for (Explosao explosao : explosoes) {
            // se já terminou a explosão pode ser removina na hora, pois não possui corpo fíciso
            if (explosao.terminou())
                explosoes.removeValue(explosao, false);
            else
                explosao.atualizar(delta);
        }
    }

    /**
     * Atualiza e cria novos tiros
     *
     * @param delta
     */
    private void atualizarTiros(float delta) {
        // incrementa o tempo de atraso dos tiros
        atrasoTiro += delta;
        // verifica se o personagem está atirando, se a quantidade máxima de tiros foi disparada e se o atraso já foi superado
        if (personagem.getSituacao() == Personagem.ATIRANDO && tiros.size < 3 && atrasoTiro >= 1) {
            Tiro tiro = new Tiro(recursos, mundo, camera, personagem.getPosicao().x + 1.3f);
            tiros.add(tiro);
            atrasoTiro = 0;
            recursos.smTiro.play(0.5f);
        }

        // atualiza ou destroi os tiros se ele já saiu da tela
        for (Iterator<Tiro> it = tiros.iterator(); it.hasNext(); ) {
            Tiro tiro = it.next();
            if (tiro.estaForaDaTela() || tiro.isDestruir()) {
                it.remove();
                mundo.destroyBody(tiro.getCorpo());
            } else {
                tiro.atualizar(delta);
            }
        }
    }

    /**
     * Posiciona a câmera de acordo com a posição do personagem
     */
    private void atualizarCamera() {
        // atualiza a câmera geral para acompanhar o personagem
        // IMPLEMENTAR
    }

    /**
     * Captura as teclas pressionadas no teclado
     */
    private void capturarTeclas() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)
                && personagem.getSituacao() == Personagem.MORTO) {
            reiniciarJogo = true;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)
                && personagem.getSituacao() == Personagem.PARADO) {
            iniciarJogo();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)
                && (personagem.getSituacao() == Personagem.CORRENDO ||
                personagem.getSituacao() == Personagem.ATIRANDO)) {
            personagem.pular();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)
                && personagem.getSituacao() == Personagem.CORRENDO) {
            personagem.deslizar();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)
                && personagem.getSituacao() == Personagem.CORRENDO) {
            personagem.atirar();
        }
    }

    /**
     * Inicia o jogo quando o ENTER é pressionado ou ocorre um toque/clique na tela
     */
    private void iniciarJogo() {
        recursos.msMenu.stop();
        recursos.msJogo.play();
        personagem.correr();
    }

}
