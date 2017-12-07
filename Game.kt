class Game (r:Int, c:Int) {
	private val grid: Array<CharArray>
	private val nearby: Array<IntArray>
	private val glider = arrayOf<CharArray>(
			charArrayOf('.', '*', '.'),
			charArrayOf('.', '.', '*'),
			charArrayOf('*', '*', '*'))
	
	init {
		grid = Array<CharArray>(r, {CharArray(c)})
		nearby = Array<IntArray>(r, {IntArray(c)})
	}
	
	fun fill() {
		for (i in grid.indices) {
			for (j in 0 until grid[i].size) {
				grid[i][j] = '.'
			}
		}
		putLife(0,0)
	}
	
	fun putLife(r:Int, c:Int) {
		var row = 0
		var col = 0
		for (i in r until glider.size + r) {
			for (j in c until glider[row].size + c) {
				grid[i][j] = glider[row][col]
				col++
			}
			row++
			col = 0
		}
	}
	
	fun countN() {
		var count = 0
      for (i in grid.indices)
      {
        for (j in 0 until grid[i].size)
        {
          if (j > 0)
          {
            if (grid[i][j - 1] == '*')
            {
              count++
            }
            if (i > 0)
            {
              if (grid[i - 1][j - 1] == '*')
              {
                count++
              }
            }
            if (i < grid.size - 1)
            {
              if (grid[i + 1][j - 1] == '*')
              {
                count++
              }
            }
          }
          if (j < grid[i].size - 1)
          {
            if (grid[i][j + 1] == '*')
            {
              count++
            }
            if (i > 0)
            {
              if (grid[i - 1][j + 1] == '*')
              {
                count++
              }
            }
            if (i < grid.size - 1)
            {
              if (grid[i + 1][j + 1] == '*')
              {
                count++
              }
            }
          }
          if (i > 0)
          {
            if (grid[i - 1][j] == '*')
            {
              count++
            }
          }
          if (i < grid.size - 1)
          {
            if (grid[i + 1][j] == '*')
            {
              count++
            }
          }
          nearby[i][j] = count
          count = 0
        }
      }
    }
		
	
	fun updateGen() {
		for (i in grid.indices) {
			for (j in 0 until grid[i].size) {
				if (nearby[i][j] == 3) {
					grid[i][j] = '*'
				} else if ((nearby[i][j] == 2 || nearby[i][j] == 3) && grid[i][j] == '*') {
					grid[i][j] = '*'
				} else {
					grid[i][j] = '.'
				}
			}
		}
	}
	
	fun show() {
		for (i in grid.indices) {
			for (j in 0 until grid[i].size) {
				print(grid[i][j])
			}
			println()
		}
	}
}