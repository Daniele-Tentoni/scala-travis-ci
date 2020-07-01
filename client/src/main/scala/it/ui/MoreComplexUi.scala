package it.ui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text

object MoreComplexUi extends JFXApp{
  stage = new PrimaryStage {
    title = "More complex app"
    scene = new Scene {
      fill = White
      content = new HBox {
        padding = Insets(20)
        children = Seq(
          new Text {
            text = "New game"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(PaleGreen, SeaGreen)
            )
          },
          new Text {
            text = "Load game"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(SeaGreen, PaleGreen)
            )
          },
          new Text {
            text = "Settings"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(SeaGreen, PaleGreen)
            )
          }
        )
      }
    }
  }
}
