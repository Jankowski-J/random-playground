const {GraphQLServer} = require('graphql-yoga');
const {prisma} = require('./generated/prisma-client');

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
        feed: (root, args, context, info) => {
            return context.prisma.links()
        },
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
        post: (root, args, context) => {
            return context.prisma.createLink({
                url: args.url,
                description: args.description,
            })
        },
        // updateLink: (parent, args) => {
        //     const linkIndex = links.findIndex(x => x.id === args.id);
        //     const link = links[linkIndex];
        //     link.url = args.url;
        //     link.description = args.description;
        //     return link;
        // },
        // deleteLink: (id) => {
        //     const linkIndex = links.findIndex(x => x.id === id);
        //     const spliced = links.splice(linkIndex, 1);
        //     return spliced[0];
        // }
    },
};

const server = new GraphQLServer({
    typeDefs: './src/schema.graphql',
    resolvers,
    context: {prisma}
});

server.start(() => console.log('Server is running on http://localhost:4000'));
