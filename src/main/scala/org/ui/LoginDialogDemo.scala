/*
package org.ui

import javafx.scene.Node
import scalafx.application.{JFXApp, Platform}
import scalafx.geometry.Insets
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control.{ButtonType, DConvert, Dialog, Label, PasswordField, TextField}
import scalafx.scene.layout.GridPane

object LoginDialogDemo extends JFXApp{
  case class Result(username: String, password: String)

  // Create the custom dialog.
  val dialog: Dialog[Result] = new Dialog[Result]() {
    initOwner(stage)
    title = "Login Dialog"
    headerText = "Look, a Custom Login Dialog"
  }

  // Set the button types.
  val loginButtonType = new ButtonType("Login", ButtonData.OKDone)
  // dialog.dialogPane().buttonTypes = Seq(loginButtonType, ButtonType.Cancel)

  // Create the username and password labels and fields.
  val username: TextField = new TextField() {
    promptText = "Username"
  }
  val password: PasswordField = new PasswordField() {
    promptText = "Password"
  }

  val grid: GridPane = new GridPane() {
    hgap = 10
    vgap = 10
    padding = Insets(20, 100, 10, 10)

    add(new Label("Username:"), 0, 0)
    add(username, 1, 0)
    add(new Label("Password:"), 0, 1)
    add(password, 1, 1)
  }

  // Enable/Disable login button depending on whether a username was
  // entered.
  val loginButton: Node = dialog.dialogPane().lookupButton(loginButtonType)
  loginButton.setDisable(true)

  // Do some validation (disable when username is empty).
  username.text.onChange { (_, _, newValue) =>
    loginButton.setDisable(newValue.trim().isEmpty)
  }

  dialog.dialogPane().setContent(grid)

  // Request focus on the username field by default.
  Platform.runLater(username.requestFocus())

  // When the login button is clicked, convert the result to
  // a username-password-pair.
  dialog.resultConverter = dialogButton =>
    if (dialogButton == loginButtonType)
      Result(username.text(), password.text())
    else
      null

  val result: Option[DConvert[Result, Result => Result]#S] = dialog.showAndWait()

  result match {
    case Some(Result(u, p)) => println("Username=" + u + ", Password=" + p)
    case None               => println("Dialog returned: None")
  }
}
*/
