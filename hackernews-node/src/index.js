const {GraphQLServer} = require('graphql-yoga');

let links = [{
    id: 'link-0',
    url: 'www.howtographql.com',
    description: 'Fullstack tutorial for GraphQL'
}];

let idCount = links.length;

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
        authors: () => people,
        link: (id) => links.find(x => x.id === id)
    },
    Person: {
        name: (parent) => parent.name,
        age: (parent) => parent.age,
        bebech: (parent) => parent.bebech
    },
    Bebech: {
        capacity: (parent) => parent.capacity,
        items: (parent) => parent.items
    },
    Mutation: {
        // 2
        post: (parent, args) => {
            const link = {
                id: `link-${idCount++}`,
                description: args.description,
                url: args.url,
            };
            links.push(link);
            return link
        },
        updateLink: (parent, args) => {
            const linkIndex = links.findIndex(x => x.id === args.id);
            const link = links[linkIndex];
            link.url = args.url;
            link.description = args.description;
            return link;
        },
        deleteLink: (id) => {
            const linkIndex = links.findIndex(x => x.id === id);
            const spliced = links.splice(linkIndex, 1);
            return spliced[0];
        }
    },
};

const server = new GraphQLServer({
    typeDefs: './src/schema.graphql',
    resolvers
});

server.start(() => console.log('Server is running on http://localhost:4000'));
