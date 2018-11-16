using UnionTypes.Lib;

namespace UnionTypes.Console
{
    public static class Program
    {
        static void Main(string[] args)
        {
            var result = Say.getUnionType(2);

            var i = result as UnionTypes.Lib.IntOrBool.I;
            var b = result as IntOrBool.B;
            System.Console.WriteLine("Hello World!");
        }
    }
}