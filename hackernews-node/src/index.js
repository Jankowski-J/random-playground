const {GraphQLServer} = require('graphql-yoga');

const typeDefs = `
type Query {
    info: String!
    feed: [Link!]!
    authors: [Person!]!
}

type Link {
    id: ID!
    description: String!
    url: String!
}

type Person {
    name: String!
    age: Int!
    bebech: Bebech
}

type Bebech {
    capacity: Float!
    items: [String!]!
}
`;

let links = [{
    id: 'link-0',
    url: 'www.howtographql.com',
    description: 'Fullstack tutorial for GraphQL'
}];

let people = [
    {
        name: 'Paweł',
        age: 7,
        bebech: {
            capacity: 3.5,
            items: ['Pizza', 'Yerba']
        }
    }
];

const resolvers = {
    Query: {
        info: () => `This is the API of a Hackernews Clone`,
        feed: () => links,
        authors: () => people
    },
    Link: {
        id: (parent) => parent.id,
        description: (parent) => parent.description,
        url: (parent) => parent.url,
    },
    Person: {
        name: (parent) => parent.name,
        age: (parent) => parent.age,
        bebech: (parent) => parent.bebech
    },
    Bebech: {
        capacity: (parent) => parent.capacity,
        items: (parent) => parent.items
    }
};

const server = new GraphQLServer({
    typeDefs,
    resolvers
});

server.start(() => console.log('Server is running on http://localhost:4000'));
