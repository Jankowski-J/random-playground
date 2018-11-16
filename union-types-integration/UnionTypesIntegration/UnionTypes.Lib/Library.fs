namespace UnionTypes.Lib

type IntOrBool = 
    | I of int
    | B of bool     

module Say =
    let hello name =
        printfn "Hello %s" name
    
    let getUnionType (n: int) =
        match n % 2 with 
        | 0 -> I n
        | 1 -> B true
        | _ -> B false
