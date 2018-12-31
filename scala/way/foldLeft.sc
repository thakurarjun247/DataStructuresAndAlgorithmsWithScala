val s="aabbbcddd"
println("second last element of list: ")
s.foldLeft("", s.head, 1)((p,c)=>p==c match {
  case true=> (p._1, c, p._3+1)
  case false => (p._1+"c".toString, c, 1)
})
//sofar, lastchar, lastcount