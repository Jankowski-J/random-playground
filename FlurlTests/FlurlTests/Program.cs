using Flurl;
using System;

namespace FlurlTests
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            var url = new Url("https://zapo-frontend.azurewebsites.net")
            .AppendPathSegment("#/reset-password")
            .SetQueryParam("token", "tokenik")
            .SetQueryParam("userId", "użyszkodnik");

            Console.WriteLine(url);
        }
    }
}
