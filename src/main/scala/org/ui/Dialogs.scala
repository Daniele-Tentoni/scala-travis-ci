package org.ui

import java.io.{FileNotFoundException, PrintWriter, StringWriter}

import scalafx.application.JFXApp
import scalafx.scene.control.{Alert, ButtonType, Label, TextArea}
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.layout.{GridPane, Priority}

object Dialogs extends JFXApp {
  // Sample dialog.
  new Alert(AlertType.Information, "Hello dialogs!!!").showAndWait()

  // Costumized dialog.
  new Alert(AlertType.Information) {
    initOwner(stage) // Block the owner while the dialog is up.
    title = "Information Dialog"
    headerText = "Loog, an info dialog"
    contentText = "I have a great message for you"
  }.showAndWait()

  // Other similar values are Warning, Error
  val conf: Alert = new Alert(AlertType.Confirmation) {
    initOwner(stage)
    title = "Confirmation dialog"
    headerText = "Look, a confirmation dialog"
    contentText = "Are you ok with this?"
  }

  val result: Option[ButtonType] = conf.showAndWait()

  // Here we can react to user input
  result match {
    case Some(ButtonType.OK) => println("OK")
    case _ => println("Cancel or something else")
  }

  // Here we have custom buttons.
  val ButtonTypeOne = new ButtonType("One")
  val ButtonTypeTwo = new ButtonType("Two")
  val ButtonTypeThree = new ButtonType("Three")

  val alert: Alert = new Alert(AlertType.Confirmation) {
    initOwner(stage)
    title = "Confirmation Dialog with Custom Actions"
    headerText = "Look, a Confirmation Dialog with Custom Actions"
    contentText = "Choose your option."

    buttonTypes = Seq(
      ButtonTypeOne, ButtonTypeTwo, ButtonTypeThree, ButtonType.Cancel
    )
  }

  val res: Option[ButtonType] = alert.showAndWait()

  res match {
    case Some(ButtonTypeOne) => println("... choosed One")
    case Some(ButtonTypeTwo) => println("... choosed Two")
    case Some(ButtonTypeThree) => println("... choosed Three")
    case _ => println("... choosed Cancel")
  }

  // Create expandable Exception.
  val exceptionText = {
    val ex = new FileNotFoundException("Could not find file blabla.txt")
    val sw = new StringWriter()
    val pw = new PrintWriter(sw)
    ex.printStackTrace(pw)
    sw.toString
  }
  val label = new Label("The exception stacktrace was:")
  val textArea = new TextArea {
    text = exceptionText
    editable = false
    wrapText = true
    maxWidth = Double.MaxValue
    maxHeight = Double.MaxValue
    vgrow = Priority.Always
    hgrow = Priority.Always
  }
  val expContent = new GridPane {
    maxWidth = Double.MaxValue
    add(label, 0, 0)
    add(textArea, 0, 1)
  }

  new Alert(AlertType.Error) {
    initOwner(stage)
    title = "Exception Dialog"
    headerText = "Look, an Exception Dialog."
    contentText = "Could not find file blabla.txt!"
    // Set expandable Exception into the dialog pane.
    dialogPane().setExpandableContent(expContent)
  }.showAndWait()
}
