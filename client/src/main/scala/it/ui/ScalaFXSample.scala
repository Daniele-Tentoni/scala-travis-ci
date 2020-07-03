package it.ui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.paint.Color.{Black, Cyan, DodgerBlue, PaleGreen, SeaGreen}
import scalafx.scene.text.Text

object ScalaFXSample extends JFXApp {
  stage = new PrimaryStage {
    title = "Scala FX Sample"
    scene = new Scene {
      fill = Black
      content = new HBox {
        padding = Insets(20)
        children = Seq(
          new Text {
            text = "Hello "
            style = "-fx-font-size: 48pt"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(PaleGreen, SeaGreen)
            )
          },
          new Text {
            text = "World!!!"
            style = "-fx-font-size: 48pt"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Cyan, DodgerBlue)
            )
            effect = new DropShadow {
              color = DodgerBlue
              radius = 25
              spread = 0.25
            }
          }
        )
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    super.main(args)
    println("Started.")
  }
}