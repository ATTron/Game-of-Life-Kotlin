import java.util.Scanner
fun main(args:Array<String>) {
	var input = Scanner(System.`in`)
	println("Enter in number of rows: ")
	val rows = input.nextInt()
	println("Enter in number of columns: ")
	val cols = input.nextInt()
	val g = Game(rows, cols)
	g.fill()
	var counter = 1
	println("How many generations? ")
	val gens = input.nextInt()
	while (counter <= gens) {
		println("Generation " + counter)
		g.show()
		g.countN()
		g.updateGen()
		Thread.sleep(500)
		counter++
		println()
	}
}