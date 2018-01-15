package io.data2viz.hierarchy

import io.data2viz.hierarchy.treemap.treemapBinary
import io.data2viz.hierarchy.treemap.treemapDice
import io.data2viz.hierarchy.treemap.treemapSlice
import io.data2viz.test.TestBase
import kotlin.test.Test

class HierarchyTests : TestBase() {

    // DO NOT CHANGE VALUES
    val width = 500.0
    val height = 400.0

    data class Hierarchical(
        val value: Int,
        val x0: Double? = null,
        val y0: Double? = null,
        val x1: Double? = null,
        val y1: Double? = null,
        val subElements: List<Hierarchical>? = null
    )

    val testTreemapLightSquarify = Hierarchical(
        1, .0, .0, 500.0, 400.0, listOf(
            Hierarchical(11, .0, .0, 500.0, 200.0),
            Hierarchical(12, .0, 200.0, 500.0, 400.0)
        )
    )

    val testTreemapMidSquarify =
        Hierarchical(
            1, .0, .0, 500.0, 400.0, subElements = listOf(
                Hierarchical(
                    11, 200.0, .0, 500.0, 250.0, subElements = listOf(
                        Hierarchical(111, 200.0, .0, 400.0, 125.0),
                        Hierarchical(112, 200.0, 125.0, 400.0, 250.0),
                        Hierarchical(113, 400.0, .0, 500.0, 250.0),
                        Hierarchical(
                            114, .0, .0, 200.0, 250.0, subElements = listOf(
                                Hierarchical(1141, .0, .0, 100.0, 250.0),
                                Hierarchical(1142, 100.0, .0, 200.0, 250.0)
                            )
                        )
                    )
                ),
                Hierarchical(
                    12, .0, 250.0, 500.0, 400.0, subElements = listOf(
                        Hierarchical(
                            121, .0, 250.0, 333.0, 400.0, subElements = listOf(
                                Hierarchical(1211, .0, 250.0, 167.0, 400.0),
                                Hierarchical(1212, 167.0, 250.0, 333.0, 400.0)
                            )
                        ),
                        Hierarchical(122, 333.0, 250.0, 500.0, 400.0)
                    )
                )
            )
        )

    val testTreemapMidBinary =
        Hierarchical(
            1, .0, .0, 500.0, 400.0, subElements = listOf(
                Hierarchical(
                    11, 0.0, .0, 313.0, 400.0, subElements = listOf(
                        Hierarchical(111, 200.0, 313.0, 240.0, 125.0),
                        Hierarchical(112, 0.0, 240.0, 156.0, 400.0),
                        Hierarchical(113, 156.0, 240.0, 313.0, 400.0),
                        Hierarchical(
                            114, .0, .0, 200.0, 250.0, subElements = listOf(
                                Hierarchical(1141, .0, .0, 100.0, 250.0),
                                Hierarchical(1142, 100.0, .0, 200.0, 250.0)
                            )
                        )
                    )
                ),
                Hierarchical(
                    12, 313.0, 0.0, 500.0, 400.0, subElements = listOf(
                        Hierarchical(
                            121, 313.0, 0.0, 500.0, 266.0, subElements = listOf(
                                Hierarchical(1211, 313.0, 0.0, 500.0, 133.0),
                                Hierarchical(1212, 313.0, 133.0, 500.0, 266.0)
                            )
                        ),
                        Hierarchical(122, 313.0, 267.0, 500.0, 400.0)
                    )
                )
            )
        )

    val testTreemapMidSlice =
        Hierarchical(
            1, 0.0, 0.0, 500.0, 400.0, subElements = listOf(
                Hierarchical(
                    11, 0.0, 100.0, 500.0, 250.0, subElements = listOf(
                        Hierarchical(111, 0.0, 100.0, 500.0, 150.0),
                        Hierarchical(112, 0.0, 150.0, 500.0, 200.0),
                        Hierarchical(113, 0.0, 200.0, 500.0, 250.0),
                        Hierarchical(
                            114, 0.0, 0.0, 500.0, 100.0, subElements = listOf(
                                Hierarchical(1141, 0.0, 0.0, 500.0, 50.0),
                                Hierarchical(1142, 0.0, 50.0, 500.0, 100.0)
                            )
                        )
                    )
                ),
                Hierarchical(
                    12, 0.0, 250.0, 500.0, 400.0, subElements = listOf(
                        Hierarchical(
                            121, 0.0, 0.0, 500.0, 266.0, subElements = listOf(
                                Hierarchical(1211, 0.0, 250.0, 500.0, 300.0),
                                Hierarchical(1212, 0.0, 300.0, 500.0, 350.0)
                            )
                        ),
                        Hierarchical(122, 0.0, 350.0, 500.0, 400.0)
                    )
                )
            )
        )

    val testTreemapMidDice =
        Hierarchical(
            1, 0.0, 0.0, 500.0, 400.0, subElements = listOf(
                Hierarchical(
                    11, 125.0, 0.0, 313.0, 250.0, subElements = listOf(
                        Hierarchical(111, 125.0, 0.0, 188.0, 400.0),
                        Hierarchical(112, 188.0, 0.0, 250.0, 400.0),
                        Hierarchical(113, 250.0, 0.0, 313.0, 400.0),
                        Hierarchical(
                            114, 0.0, 0.0, 500.0, 100.0, subElements = listOf(
                                Hierarchical(1141, 0.0, 0.0, 63.0, 400.0),
                                Hierarchical(1142, 63.0, 0.0, 125.0, 400.0)
                            )
                        )
                    )
                ),
                Hierarchical(
                    12, 313.0, 0.0, 500.0, 400.0, subElements = listOf(
                        Hierarchical(
                            121, 0.0, 0.0, 500.0, 400.0, subElements = listOf(
                                Hierarchical(1211, 313.0, 250.0, 375.0, 400.0),
                                Hierarchical(1212, 375.0, 300.0, 438.0, 400.0)
                            )
                        ),
                        Hierarchical(122, 438.0, 0.0, 500.0, 400.0)
                    )
                )
            )
        )

    @Test
    fun buildHierarchy() {
        val hierarchy = hierarchy(Hierarchical(0), { it.subElements })

        hierarchy.descendants().size shouldBe 1
        hierarchy.leaves().size shouldBe 1
    }

    @Test
    fun buildHierarchyFull() {
        val hierarchy = hierarchy(testTreemapMidSquarify, { it.subElements })

        hierarchy.descendants().size shouldBe 3
        hierarchy.leaves().size shouldBe 8
    }

    @Test
    fun buildTreemapLight() {
        val hierarchy = hierarchy(testTreemapLightSquarify, { it.subElements })
        hierarchy.sum({ it.value.toDouble() })
        hierarchy.sum { if (it.subElements == null) 1.0 else .0 }

        val layout = TreemapLayout<Hierarchical>()
        layout.width = width
        layout.height = height
        layout.roundPositions = true

        val treemap  = layout.treemap(hierarchy)
        treemap.each { treemapNode ->
            treemapNode.x0 shouldBe treemapNode.data.x0
            treemapNode.x1 shouldBe treemapNode.data.x1
            treemapNode.y0 shouldBe treemapNode.data.y0
            treemapNode.y1 shouldBe treemapNode.data.y1
        }
    }

    @Test
    fun buildTreemapMidSquarify() {
        val hierarchy = hierarchy(testTreemapMidSquarify, { it.subElements })
        hierarchy.sum({ it.value.toDouble() })
        hierarchy.sum { if (it.subElements == null) 1.0 else .0 }

        val layout = TreemapLayout<Hierarchical>()
        layout.paddingInner = { .0 }
        layout.paddingOuter = { .0 }
        layout.width = width
        layout.height = height
        layout.roundPositions = true

        val treemap  = layout.treemap(hierarchy)
        treemap.each { treemapNode ->
            treemapNode.x0 shouldBe treemapNode.data.x0
            treemapNode.x1 shouldBe treemapNode.data.x1
            treemapNode.y0 shouldBe treemapNode.data.y0
            treemapNode.y1 shouldBe treemapNode.data.y1
        }
    }

    @Test
    fun buildTreemapMidBinary() {
        val hierarchy = hierarchy(testTreemapMidBinary, { it.subElements })
        hierarchy.sum({ it.value.toDouble() })
        hierarchy.sum { if (it.subElements == null) 1.0 else .0 }

        val layout = TreemapLayout<Hierarchical>()
        layout.paddingInner = { .0 }
        layout.paddingOuter = { .0 }
        layout.width = width
        layout.height = height
        layout.roundPositions = true
        layout.tilingMethod = { parent, x0, y0, x1, y1 ->
            treemapBinary(parent, x0, y0, x1, y1) }

        val treemap  = layout.treemap(hierarchy)
        treemap.each { treemapNode ->
            treemapNode.x0 shouldBe treemapNode.data.x0
            treemapNode.x1 shouldBe treemapNode.data.x1
            treemapNode.y0 shouldBe treemapNode.data.y0
            treemapNode.y1 shouldBe treemapNode.data.y1
        }
    }

    @Test
    fun buildTreemapMidSlice() {
        val hierarchy = hierarchy(testTreemapMidSlice, { it.subElements })
        hierarchy.sum({ it.value.toDouble() })
        hierarchy.sum { if (it.subElements == null) 1.0 else .0 }

        val layout = TreemapLayout<Hierarchical>()
        layout.paddingInner = { .0 }
        layout.paddingOuter = { .0 }
        layout.width = width
        layout.height = height
        layout.roundPositions = true
        layout.tilingMethod = { parent, x0, y0, x1, y1 -> treemapSlice(parent, x0, y0, x1, y1) }

        val treemap  = layout.treemap(hierarchy)
        treemap.each { treemapNode ->
            treemapNode.x0 shouldBe treemapNode.data.x0
            treemapNode.x1 shouldBe treemapNode.data.x1
            treemapNode.y0 shouldBe treemapNode.data.y0
            treemapNode.y1 shouldBe treemapNode.data.y1
        }
    }

    @Test
    fun buildTreemapMidDice() {
        val hierarchy = hierarchy(testTreemapMidDice, { it.subElements })
        hierarchy.sum({ it.value.toDouble() })
        hierarchy.sum { if (it.subElements == null) 1.0 else .0 }

        val layout = TreemapLayout<Hierarchical>()
        layout.paddingInner = { .0 }
        layout.paddingOuter = { .0 }
        layout.width = width
        layout.height = height
        layout.roundPositions = true
        layout.tilingMethod = { parent, x0, y0, x1, y1 -> treemapDice(parent, x0, y0, x1, y1) }

        val treemap  = layout.treemap(hierarchy)
        treemap.each { treemapNode ->
            treemapNode.x0 shouldBe treemapNode.data.x0
            treemapNode.x1 shouldBe treemapNode.data.x1
            treemapNode.y0 shouldBe treemapNode.data.y0
            treemapNode.y1 shouldBe treemapNode.data.y1
        }
    }

    @Test
    fun buildTree() {
        val hierarchy = hierarchy(testTreemapMidSquarify, { it.subElements })
        val tree = tree(hierarchy)
    }

    @Test
    fun buildCluster() {
        val hierarchy = hierarchy(testTreemapMidSquarify, { it.subElements })
        val cluster = cluster(hierarchy)
    }
}