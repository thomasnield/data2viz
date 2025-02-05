package io.data2viz.examples.events

import io.data2viz.viz.ExperimentalKEvent
import io.data2viz.viz.Viz
import io.data2viz.viz.bindRendererOn
import org.w3c.dom.Element
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener
import kotlin.browser.document

@ExperimentalKEvent
fun main() {
    val eventsViz = eventsViz()
    eventsViz.bindRendererOn("events")

    val button = document.getElementById("button_toggle_events")!!
    button.addEventListener("click", object : EventListener {
        override fun handleEvent(event: Event) {
            toggleEventsState(eventsViz, button)
        }

    })

    toggleEventsState(eventsViz, button)

}

@ExperimentalKEvent
private fun toggleEventsState(
    viz: Viz,
    button: Element
) {
    if (isEventsAdded) {
        removeEvents()
        button.innerHTML = addEventsText
    } else {
        viz.addEvents()
        button.innerHTML = removeEventsText
    }
}
