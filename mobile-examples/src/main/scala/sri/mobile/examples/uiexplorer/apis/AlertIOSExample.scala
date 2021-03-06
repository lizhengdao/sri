package sri.mobile.examples.uiexplorer.apis

import sri.core.ReactComponent
import sri.mobile.ReactNative
import sri.mobile.all._
import sri.mobile.apis.ios.AlertIOSButton
import sri.mobile.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}


object AlertIOSExample extends UIExample {
  override def title: String = "AlertIOS"


  val Component = () => {
    val a1 = () => ReactNative.AlertIOS.alert("Foo title", "alert message")
    val a2 = () => ReactNative.AlertIOS.alert(title = "Foo Title", buttons = js.Array(AlertIOSButton("Button", () => println("Button Pressed")).toJson))
    val a3 = () => ReactNative.AlertIOS.alert(
      title = "Foo Title",
      message = "My Alert Msg",
      buttons = js.Array(AlertIOSButton("Foo", () => println("Foo Button Pressed")).toJson,
        AlertIOSButton("Bar", () => println("Bar Button Pressed")).toJson))
    val a4 = () => ReactNative.AlertIOS.alert(
      title = "Foo Title",
      buttons = js.Array(AlertIOSButton("Foo", () => println("Foo Button Pressed")).toJson,
        AlertIOSButton("Bar", () => println("Bar Button Pressed")).toJson,
        AlertIOSButton("Baz", () => println("Baz Button Pressed")).toJson))
    val a5 = () => ReactNative.AlertIOS.alert(title = "Foo title",
      buttons = (1 to 10).map(i => AlertIOSButton(s"Button $i", () => println(s"Button $i pressed")).toJson.asInstanceOf[js.Object]).toJSArray)

    UIExplorerPage(
      UIExplorerBlock("Alerts")(
        View(style = json(flex = 1))(
          TouchableHighlight(style = styles.wrapper, onPress = a1)(
            View(style = styles.button)(
              Text()("Alert Message with default button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a2)(
            View(style = styles.button)(
              Text()("Alert with only one button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a3)(
            View(style = styles.button)(
              Text()("Alert with two buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a4)(
            View(style = styles.button)(
              Text()("Alert with 3 buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a5)(
            View(style = styles.button)(
              Text()("Alert with too many buttons")
            )
          )
        )
      )
    )
  }


  val component = () =>  createStatelessFunctionElementNoProps(Component)

  object styles extends UniversalStyleSheet {
    val alertsContainer = style(backgroundColor := "white",
      padding := 20)
    val wrapper = style(borderRadius := 5, marginBottom := 5)
    val button = style(backgroundColor := "#eeeeee", padding := 10)
  }

  override def description: String = "iOS alerts and action sheets"
}
