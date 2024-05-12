package cl.uchile.dcc.finalreality.gui;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import cl.uchile.dcc.finalreality.gui.assets.effects.EffectSprite;
import cl.uchile.dcc.finalreality.gui.assets.effects.EffectSpriteSetter;
import cl.uchile.dcc.finalreality.gui.assets.units.AnimatedSprite;
import cl.uchile.dcc.finalreality.gui.assets.units.UnitSprite;
import cl.uchile.dcc.finalreality.gui.assets.units.UnitSpriteSetter;
import cl.uchile.dcc.finalreality.gui.assets.units.states.*;
import cl.uchile.dcc.finalreality.gui.assets.weapons.WeaponSprite;
import cl.uchile.dcc.finalreality.gui.assets.weapons.WeaponSpriteSetter;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class BattleScreenController implements GameSceneController {

  @FXML
  public StackPane sceneContainer;
  @FXML
  public AnchorPane contentContainer;
  @FXML
  public VBox options;
  @FXML
  public HBox enemiesInfo;
  @FXML
  public VBox output;
  @FXML
  public HBox partyInfo;
  @FXML
  public FlowPane menuWrapper;

  public static final int EXPAND_RATIO = 4;
  public static final Image PLAYER_SPRITE = new Image(
      BattleScreenController.class.getResource("assets/player_sprites.png").toExternalForm(),
      264 * EXPAND_RATIO,
      288 * EXPAND_RATIO,
      true,
      false
  );
  public static final Image WEAPON_SPRITE = new Image(
      BattleScreenController.class.getResource("assets/weapon_animation.png").toExternalForm(),
      840 * EXPAND_RATIO,
      1000 * EXPAND_RATIO,
      true,
      false
  );
  public static final Image ENEMY_SPRITE = new Image(
      BattleScreenController.class.getResource("assets/enemies_sprites.png").toExternalForm(),
      840 * EXPAND_RATIO,
      640 * EXPAND_RATIO,
      true,
      false
  );
  public static final Image EFFECT_SPRITE = new Image(
      BattleScreenController.class.getResource("assets/effects_sprites.png").toExternalForm(),
      32 * EXPAND_RATIO,
      24 * EXPAND_RATIO,
      true,
      false
  );
  public final MediaPlayer backgroundMusic = new MediaPlayer(
      new Media(BattleScreenController.class.getResource("sounds/battle.wav").toExternalForm())
  );
  public Text option1;
  public Text option2;
  public Text option3;
  private final Text outputText = new Text();
  private final IntegerProperty paddingSize = new SimpleIntegerProperty(10);
  public VBox unitsHealthBars;
  public VBox unitsNames;
  public VBox unitsHealthDetails;
  public VBox enemiesNames;
  public VBox enemiesHealthDetails;
  public VBox enemiesHealthBars;
  public Pane unitsContainer;
  public Pane enemiesContainer;
  private final HashMap<GameUnit, UnitSprite> unitsSpriteMap = new HashMap<>();
  private final HashMap<GameUnit, ImageView> unitsImagesMap = new HashMap<>();
  private final ArrayList<UnitSprite> unitSprites = new ArrayList<>();
  private final ArrayList<ImageView> unitSpritesImages = new ArrayList<>();
  private final HashMap<Enemy, ArrayList<EffectSprite>> effectsSpriteMap = new HashMap<>();
  private final HashMap<Enemy, VBox> effectsImageMap = new HashMap<>();
  private final ArrayList<EffectSprite> effectsSprite = new ArrayList<>();
  private final ArrayList<ImageView> effectsImageSprite = new ArrayList<>();

  public void initialize() {

    Image image = new Image(BattleScreenController.class.getResource(
        "assets/background.png").toExternalForm(),
        1920,
        1080,
        true,
        false
    );
    BackgroundImage backgroundImage = new BackgroundImage(
        image,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(
            BackgroundSize.AUTO,
            BackgroundSize.AUTO,
            false,
            false,
            true,
            false
        )
    );
    contentContainer.setBackground(new Background(backgroundImage));

    double aspectRatio = 256.0 / 156.0;
    contentContainer.maxWidthProperty().bind(Bindings.min(
        sceneContainer.widthProperty(), sceneContainer.heightProperty().multiply(aspectRatio)
    ));
    contentContainer.maxHeightProperty().bind(Bindings.min(
        sceneContainer.heightProperty(), sceneContainer.widthProperty().divide(aspectRatio)
    ));

    setSize(output, 0.595, 0.09);
    setSize(options, 0.21, 0.25);
    setSize(enemiesInfo, 0.38, 0.25);
    setSize(partyInfo, 0.38, 0.25);

    menuWrapper.maxWidthProperty().bind(contentContainer.widthProperty().multiply(0.99));
    menuWrapper.minWidthProperty().bind(contentContainer.widthProperty().multiply(0.99));
    AnchorPane.setBottomAnchor(menuWrapper, 5.0);

    DoubleProperty fontSize = new SimpleDoubleProperty(10);

    paddingSize.bind(options.heightProperty().divide(6));
    fontSize.bind(options.heightProperty().subtract(paddingSize).divide(4));
    options.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";",
        "-fx-padding:", paddingSize.asString(), "px ", paddingSize.asString(), "px;"));
    output.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";",
        "-fx-padding:", paddingSize.divide(2).asString(), "px ", paddingSize.asString(), "px;"));
    partyInfo.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";",
        "-fx-padding:", paddingSize.divide(2).asString(), "px ", paddingSize.asString(), "px;",
        "-fx-spacing:", paddingSize.asString(), "px "));
    enemiesInfo.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";",
        "-fx-padding:", paddingSize.divide(2).asString(), "px ", paddingSize.asString(), "px;",
        "-fx-spacing:", paddingSize.asString(), "px "));

    outputText.getStyleClass().add("textContent");
    output.getChildren().add(outputText);

    AnchorPane.setRightAnchor(unitsContainer, 0.0);
    AnchorPane.setTopAnchor(unitsContainer, 0.0);
    unitsContainer.minHeightProperty().bind(contentContainer.heightProperty()
        .multiply(0.99)
        .subtract(menuWrapper.heightProperty()));
    unitsContainer.minWidthProperty().bind(contentContainer.widthProperty().divide(2));

    AnchorPane.setLeftAnchor(enemiesContainer, 0.0);
    AnchorPane.setTopAnchor(enemiesContainer, 0.0);
    enemiesContainer.minHeightProperty().bind(contentContainer.heightProperty()
        .multiply(0.99)
        .subtract(menuWrapper.heightProperty()));
    enemiesContainer.minWidthProperty().bind(contentContainer.widthProperty().divide(2));

    Timeline spriteAnimation = new Timeline(new KeyFrame(Duration.millis(100), actionEvent -> {
      for (int i = 0; i < unitSprites.size(); i++) unitSprites.get(i).setViewport(unitSpritesImages.get(i));
      for (int i = 0; i < effectsSprite.size(); i++) effectsSprite.get(i).setViewport(effectsImageSprite.get(i));
    }));
    spriteAnimation.setCycleCount(Animation.INDEFINITE);
    spriteAnimation.play();
  }

  public void startMusic() {
    backgroundMusic.setOnEndOfMedia(() -> backgroundMusic.seek(Duration.ZERO));
    backgroundMusic.play();
  }

  public void stopMusic() {
    backgroundMusic.stop();
  }

  private void setSize(Pane menuElement, double width, double height) {
    menuElement.maxWidthProperty().bind(contentContainer.widthProperty().multiply(width));
    menuElement.minWidthProperty().bind(contentContainer.widthProperty().multiply(width));
    menuElement.maxHeightProperty().bind(contentContainer.heightProperty().multiply(height));
    menuElement.minHeightProperty().bind(contentContainer.heightProperty().multiply(height));
  }

  public void updateEffects(Enemy enemy) {
    ArrayList<EffectSprite> sprites = effectsSpriteMap.get(enemy);
    VBox images = effectsImageMap.get(enemy);

    EffectSpriteSetter spriteSetter = new EffectSpriteSetter();

    for (EffectSprite sprite : sprites) effectsSprite.remove(sprite);
    for (Node image : images.getChildren()) effectsImageSprite.remove((ImageView) image);

    sprites.clear();
    images.getChildren().clear();

    for (Effect effect : enemy.getEffects()) {
      EffectSprite effectSprite = effect.accept(spriteSetter);
      ImageView imageView = effectSprite.getImage();
      imageView.fitHeightProperty().bind(images.heightProperty().divide(3));
      imageView.fitWidthProperty().bind(images.heightProperty().divide(1.5));
      images.getChildren().add(imageView);
      sprites.add(effectSprite);
      effectsSprite.add(effectSprite);
      effectsImageSprite.add(imageView);
    }
  }

  public void updateUnitSprites() {
    UnitSpriteSetter spriteSetter = new UnitSpriteSetter();
    ArrayList<PlayerUnit> units = GameDriver.DRIVER().getPlayer().getParty();
    int value = 1;
    for (PlayerUnit unit : units) {
      UnitSprite sprite = unit.accept(spriteSetter);
      ImageView spriteImage = sprite.getImage();
      spriteImage.fitWidthProperty().bind(unitsContainer.heightProperty().divide(GameDriver.UNITS_AMOUNT + 0.75));
      spriteImage.fitHeightProperty().bind(unitsContainer.heightProperty().divide(GameDriver.UNITS_AMOUNT + 0.75));
      spriteImage.layoutYProperty().bind(unitsContainer.heightProperty()
          .divide(GameDriver.UNITS_AMOUNT + 1)
          .multiply(value)
          .subtract(unitsContainer.heightProperty().divide(20).multiply(value))
          .add(spriteImage.fitHeightProperty().divide(2)));
      spriteImage.layoutXProperty().bind(unitsContainer.widthProperty()
          .divide(3)
          .add(spriteImage.fitWidthProperty().divide(2).multiply(value))
      );
      unitsContainer.getChildren().add(spriteImage);
      unitsSpriteMap.put(unit, sprite);
      unitsImagesMap.put(unit, spriteImage);
      unitSprites.add(sprite);
      unitSpritesImages.add(spriteImage);
      value++;
    }
    ArrayList<Enemy> enemies = GameDriver.DRIVER().getEnemies();
    value = 0;
    for (Enemy enemy : enemies) {
      UnitSprite sprite = enemy.accept(spriteSetter);
      ImageView spriteImage = sprite.getImage();
      spriteImage.fitWidthProperty().bind(enemiesContainer.heightProperty().divide(GameDriver.ENEMIES_AMOUNT - 1.25));
      spriteImage.fitHeightProperty().bind(enemiesContainer.heightProperty().divide(GameDriver.ENEMIES_AMOUNT - 1.25));
      spriteImage.layoutYProperty().bind(enemiesContainer.heightProperty()
          .divide(4.75)
          .multiply(value)
          .subtract(enemiesContainer.heightProperty().divide(10))
      );
      spriteImage.layoutXProperty().bind(enemiesContainer.widthProperty()
          .divide(2)
          .subtract(enemiesContainer.widthProperty().multiply(0.75).divide(GameDriver.ENEMIES_AMOUNT + 1).multiply(value))
      );
      enemiesContainer.getChildren().add(spriteImage);
      unitsSpriteMap.put(enemy, sprite);
      unitsImagesMap.put(enemy, spriteImage);
      unitSprites.add(sprite);
      unitSpritesImages.add(spriteImage);

      VBox effectContainer = new VBox();
      ArrayList<EffectSprite> effectSprites = new ArrayList<>();
      effectContainer.minHeightProperty().bind(spriteImage.fitHeightProperty().divide(3));
      effectContainer.maxHeightProperty().bind(spriteImage.fitHeightProperty().divide(3));
      effectContainer.layoutXProperty().bind(spriteImage.layoutXProperty()
          .add(spriteImage.fitWidthProperty().divide(2)));
      effectContainer.layoutYProperty().bind(spriteImage.layoutYProperty()
          .add(spriteImage.fitHeightProperty().divide(2)));
      enemiesContainer.getChildren().add(effectContainer);
      effectsSpriteMap.put(enemy, effectSprites);
      effectsImageMap.put(enemy, effectContainer);
      value++;
    }
  }

  private void changeSpriteAnimation(PlayerUnit unit, AnimationState state) {
    AnimatedSprite sprite = (AnimatedSprite) unitsSpriteMap.get(unit);
    sprite.setState(state);
  }

  public void useWeapon(PlayerUnit unit) {
    changeSpriteAnimation(unit, new Standing());
    WeaponSprite weaponSprite = unit.getWeapon().accept(new WeaponSpriteSetter());
    ImageView imageView = weaponSprite.getImage();
    int index = unitsContainer.getChildren().indexOf(unitsImagesMap.get(unit));
    unitsContainer.getChildren().add(index, imageView);
    ImageView reference = unitsImagesMap.get(unit);

    imageView.layoutXProperty().bind(reference.layoutXProperty().subtract(reference.fitWidthProperty().multiply(0.5)));
    imageView.layoutYProperty().bind(reference.layoutYProperty().subtract(reference.fitHeightProperty().multiply(1.2)));
    imageView.translateXProperty().bind(reference.translateXProperty());
    imageView.translateYProperty().bind(reference.translateYProperty());
    imageView.fitWidthProperty().bind(reference.fitWidthProperty().multiply(2));
    imageView.fitHeightProperty().bind(reference.fitHeightProperty().multiply(2));

    Timeline timeline = getTimeline(weaponSprite, imageView);
    timeline.play();
  }

  private Timeline getTimeline(WeaponSprite weaponSprite, ImageView imageView) {
    return new Timeline(
        new KeyFrame(Duration.millis(75), actionEvent -> {
          weaponSprite.setViewport(imageView);
        }),
        new KeyFrame(Duration.millis(150), actionEvent -> {
          weaponSprite.setViewport(imageView);
        }),
        new KeyFrame(Duration.millis(225), actionEvent -> {
          weaponSprite.setViewport(imageView);
        }),
        new KeyFrame(Duration.millis(300), actionEvent -> {
          weaponSprite.setViewport(imageView);
        }),
        new KeyFrame(Duration.millis(375), actionEvent -> {
          unitsContainer.getChildren().remove(imageView);
          GameDriver.DRIVER().execute();
        })
    );
  }

  public void goToBattle(PlayerUnit unit) {
    ImageView sprite = unitsImagesMap.get(unit);
    TranslateTransition transition = new TranslateTransition(Duration.millis(600), sprite);
    transition.setToX(-100);
    transition.setOnFinished(actionEvent -> changeSpriteAnimation(unit, new Thinking()));
    changeSpriteAnimation(unit, new Walking());
    transition.play();
  }

  public void returnFromBattle(PlayerUnit unit) {
    ImageView sprite = unitsImagesMap.get(unit);
    TranslateTransition transition = new TranslateTransition(Duration.millis(600), sprite);
    transition.setToX(0);
    transition.setOnFinished(actionEvent -> {
      changeSpriteAnimation(unit, new Standing());
      sprite.setScaleX(1);
    });
    if (!unit.isDead()) {
      changeSpriteAnimation(unit, new Walking());
      sprite.setScaleX(-1);
      transition.play();
    }
  }

  public void prepareToAttack(Enemy enemy) {
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(1500), actionEvent -> GameDriver.DRIVER().execute())
    );
    timeline.play();
  }

  public void die(PlayerUnit unit) {
    changeSpriteAnimation(unit, new Dead());
  }

  public void celebrate(PlayerUnit unit) {
    changeSpriteAnimation(unit, new Celebrating());
  }

  public void getAttacked(PlayerUnit unit) {
    TranslateTransition onAttack = new TranslateTransition(Duration.millis(400), unitsImagesMap.get(unit));
    PauseTransition recover = new PauseTransition(Duration.millis(200));
    TranslateTransition afterAttack = new TranslateTransition(Duration.millis(400), unitsImagesMap.get(unit));
    onAttack.setToX(20);
    onAttack.setInterpolator(Interpolator.EASE_OUT);
    afterAttack.setToX(0);
    onAttack.setOnFinished(actionEvent -> {
      changeSpriteAnimation(unit, new Standing());
      recover.play();
    });
    recover.setOnFinished(actionEvent -> {
      changeSpriteAnimation(unit, new Walking());
      afterAttack.play();
    });
    afterAttack.setOnFinished(actionEvent -> changeSpriteAnimation(unit, new Standing()));
    changeSpriteAnimation(unit, new Attacked());
    onAttack.play();
  }

  public void enemyAttacking() {
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(1500), actionEvent -> GameDriver.DRIVER().execute())
    );
    timeline.play();
  }

  public void enemyGetAttacked(Enemy enemy) {
    ImageView sprite = unitsImagesMap.get(enemy);
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(75), actionEvent -> sprite.setOpacity(0.0)),
        new KeyFrame(Duration.millis(150), actionEvent -> sprite.setOpacity(1.0)),
        new KeyFrame(Duration.millis(225), actionEvent -> sprite.setOpacity(0.0)),
        new KeyFrame(Duration.millis(300), actionEvent -> sprite.setOpacity(1.0)),
        new KeyFrame(Duration.millis(375), actionEvent -> sprite.setOpacity(0.0)),
        new KeyFrame(Duration.millis(450), actionEvent -> sprite.setOpacity(1.0))
    );
    timeline.play();
  }

  public void updateUnitDetails() {
    ArrayList<PlayerUnit> units = GameDriver.DRIVER().getPlayer().getParty();
    ArrayList<Enemy> enemies = GameDriver.DRIVER().getEnemies();

    unitsNames.getChildren().clear();
    unitsHealthDetails.getChildren().clear();
    unitsHealthBars.getChildren().clear();
    enemiesNames.getChildren().clear();
    enemiesHealthDetails.getChildren().clear();
    enemiesHealthBars.getChildren().clear();

    for (PlayerUnit unit : units) {
      setCharactersInfo(unit.toString(), unitsNames, unit.getCurrentHp(), unit.getMaxHp(), unitsHealthDetails, unitsHealthBars);
    }

    for (Enemy enemy : enemies) {
      setCharactersInfo(enemy.toString(), enemiesNames, enemy.getCurrentHp(), enemy.getMaxHp(), enemiesHealthDetails, enemiesHealthBars);
    }
  }

  private void setCharactersInfo(String string, VBox unitsNames, int currentHp, int maxHp, VBox unitsHealthDetails, VBox unitsHealthBars) {
    Text unitName = new Text(string);
    unitName.getStyleClass().add("textContent");
    unitsNames.getChildren().add(unitName);
    Text unitHealth = new Text("%d/%d".formatted(currentHp, maxHp));
    unitHealth.getStyleClass().add("textContent");
    unitsHealthDetails.getChildren().add(unitHealth);
    StackPane pane = new StackPane();
    pane.prefWidthProperty().bind(
        partyInfo.widthProperty()
            .subtract(paddingSize)
            .subtract(partyInfo.spacingProperty().multiply(2))
            .subtract(unitsNames.getWidth())
            .subtract(unitsHealthDetails.getWidth())
    );
    pane.prefHeightProperty().bind(partyInfo.heightProperty().subtract(paddingSize).divide(GameDriver.UNITS_AMOUNT));
    ProgressBar health = new ProgressBar((double) currentHp / maxHp);
    health.getStyleClass().add("health-bar");
    health.maxWidthProperty().bind(pane.widthProperty());
    health.maxHeightProperty().bind(pane.heightProperty().divide(1.75));
    pane.getChildren().add(health);
    unitsHealthBars.getChildren().add(pane);
  }

  public void updateOutput() {
    outputText.setText(GameDriver.DRIVER().getActionOutput());
  }

  public void updateOptions() {
    ArrayList<String> options = GameDriver.DRIVER().getState().getOptions();
    int cursor = GameDriver.DRIVER().getCursor(options.size());
    option1.getStyleClass().remove("selected");
    option2.getStyleClass().remove("selected");
    option3.getStyleClass().remove("selected");
    if (options.size() >= 3) {
      if (cursor == 0) {
        option1.setText(options.get(cursor));
        option2.setText(options.get(cursor + 1));
        option3.setText(options.get(cursor + 2));
        option1.getStyleClass().add("selected");
      } else if (cursor == options.size() - 1) {
        option1.setText(options.get(cursor - 2));
        option2.setText(options.get(cursor - 1));
        option3.setText(options.get(cursor));
        option3.getStyleClass().add("selected");
      } else {
        option1.setText(options.get(cursor - 1));
        option2.setText(options.get(cursor));
        option3.setText(options.get(cursor + 1));
        option2.getStyleClass().add("selected");
      }
    } else {
      option1.setText(options.get(0));
      option2.setText(options.size() > 1 ? options.get(1) : "");
      option3.setText("");
      if (cursor == 0) option1.getStyleClass().add("selected");
      else if (cursor == 1) option2.getStyleClass().add("selected");
      else option3.getStyleClass().add("selected");
    }
  }

  @Override
  public void setUpKeys() {
    Scene scene = sceneContainer.getScene();
    scene.setOnKeyPressed(keyEvent -> {
      switch (keyEvent.getCode()) {
        case ENTER -> {
          if (GameDriver.DRIVER().userInputAllowed()) {
            FinalReality.playSound(FinalReality.ENTER_SOUND);
            GameDriver.DRIVER().execute();
            updateOptions();
            updateOutput();
          }
        }
        case UP, W -> {
          if (GameDriver.DRIVER().userInputAllowed()) {
            FinalReality.playSound(FinalReality.CURSOR_SOUND);
            GameDriver.DRIVER().setCursor(-1);
            updateOptions();
          }
        }
        case DOWN, S -> {
          if (GameDriver.DRIVER().userInputAllowed()) {
            FinalReality.playSound(FinalReality.CURSOR_SOUND);
            GameDriver.DRIVER().setCursor(1);
            updateOptions();
          }
        }
        case BACK_SPACE -> {
          if (GameDriver.DRIVER().userInputAllowed()) {
            GameDriver.DRIVER().goBack();
            updateOptions();
          }
        }
      }
    });
  }
}
